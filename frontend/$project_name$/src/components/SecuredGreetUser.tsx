import { ArrowLeftOutlined } from '@ant-design/icons'
import { Button, Layout, Space, Typography } from 'antd'
import { Content } from 'antd/lib/layout/layout'
import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import UserForm from './form/UserForm'
import styles from './GreetUser.module.css'
import { PageHeader } from './pageHeader/PageHeader'

export const SecuredGreetUser = (): JSX.Element => {
  const [displayMessage, setDisplayMessage] = useState('')
  const onSubmitHandler = (message: string) => {
    setDisplayMessage(message)
  }
  const showMessage = displayMessage.length > 0
  return (
    <div>
      <PageHeader
        title={
          <Typography.Title level={2} style={{ color: 'white' }}>
            <Space>{'Secured Greeter Application'}</Space>
          </Typography.Title>
        }
        ghost={false}
        className={styles.header1}
        extra={
          <>
            <Link to={'/'}>
              <Button icon={<ArrowLeftOutlined />}>Back</Button>
            </Link>
          </>
        }
      />
      <Layout>
        <Content className={styles.content}>
          <UserForm onSubmitHandler={onSubmitHandler} isSecured />
          {showMessage && <Typography.Text>{displayMessage}</Typography.Text>}
        </Content>
      </Layout>
    </div>
  )
}

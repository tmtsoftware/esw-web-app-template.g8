import { Layout, Space, Typography } from 'antd'
import { Content } from 'antd/lib/layout/layout'
import React, { useState } from 'react'
import UserForm from './form/UserForm'
import styles from './GreetUser.module.css'
import { NavComponent } from './navigation/NavComponent'
import { PageHeader } from './pageHeader/PageHeader'

export const GreetUser = (): JSX.Element => {
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
            <Space>{'Greeter Application'}</Space>
          </Typography.Title>
        }
        ghost={false}
        className={styles.header1}
        extra={<NavComponent />}
      />
      <Layout>
        <Content className={styles.content}>
          <UserForm onSubmitHandler={onSubmitHandler} />
          {showMessage && <Typography.Text>{displayMessage}</Typography.Text>}
        </Content>
      </Layout>
    </div>
  )
}

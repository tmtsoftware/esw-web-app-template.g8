import { AuthContext, Login, Logout } from '@tmtsoftware/esw-ts'
import { Button, Space } from 'antd'
import React, { useContext } from 'react'
import { Link } from 'react-router-dom'
export const NavComponent = (): JSX.Element => {
  const { auth } = useContext(AuthContext)
  return (
    <Space>
      <Link to='/secured'>
        <Button>Secured</Button>
      </Link>
      {!auth ? (
        <span>Loading...</span>
      ) : auth.isAuthenticated() ? (
        // #logout-component-usage
        <Link to='/'>
          <Logout />
        </Link>
      ) : (
        // #logout-component-usage
        // #login-component-usage
        <Login />
        // #login-component-usage
      )}
    </Space>
  )
}

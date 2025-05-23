import { Menu } from 'antd'
import React from 'react'
import { Link } from 'react-router-dom'
import { useAuth } from '../../hooks/useAuth'

export const MenuBar = (): React.JSX.Element => {
  const { auth, login, logout } = useAuth()
  const isAuthenticated = auth?.isAuthenticated() ?? false

  const items: MenuItem[] = [
    {
      key: 'home',
      label: <Link to='/'>Home</Link>
    },
    {
      key: 'greeting',
      label: <Link to='/greeting'>Greeting</Link>
    },
    isAuthenticated
      ? {
        key: 'adminGreeting',
        label: <Link to='/adminGreeting'>AdminGreeting</Link>
      }
      : {
        key: 'login',
        label: 'Login',
        onClick: login
      },
    isAuthenticated
      ? {}
      : {
        key: 'logout',
        label: 'Logout',
        onClick: logout
      }
  ]

  return <Menu mode='horizontal' items={items} />
}

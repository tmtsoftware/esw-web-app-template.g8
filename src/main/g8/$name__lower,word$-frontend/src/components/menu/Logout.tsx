import { Menu } from 'antd'
import React from 'react'

export const Logout = ({ logout }: { logout: () => void }): React.JSX.Element => (
  <Menu.Item key='logout' onClick={logout}>
    Logout
  </Menu.Item>
)

import React, { useEffect, useState } from 'react'
import { useUsername } from '../../hooks/useAuth'

export const Welcome = (): JSX.Element => {
  const [username, setUsername] = useState<string | undefined>(undefined)
  const user = useUsername()

  useEffect(() => {
    setUsername(user)
  }, [user])

  return <>{displayMessage(`Welcome \${username ? username : 'Guest'} !!!`)}</>
}

export const displayMessage = (greeting: string): JSX.Element => (
  <Typography.Title level={3}>{greeting}</Typography.Title>
)
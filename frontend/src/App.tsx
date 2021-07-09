import { LocationService } from '@tmtsoftware/esw-ts'
import React, { useEffect, useState } from 'react'
import { BrowserRouter as Router } from 'react-router-dom'
import 'antd/dist/antd.css'
import { LocationServiceProvider } from './components/contexts/LocationServiceContext'
import { AppConfig } from './config/AppConfig'
import { Routes } from './routes/Routes'

const basename =
  import.meta.env.NODE_ENV === 'production' ? AppConfig.applicationName : ''

const App = (): JSX.Element => {
  const [locService, setLocService] = useState<LocationService>()
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(false)

  useEffect(() => {
    LocationService()
      .then((loc) => setLocService(loc))
      .catch(() => setError(true))
    setLoading(false)
  }, [])

  return (
    <>
      {locService && !loading && (
        <div>
          <LocationServiceProvider locationService={locService}>
            <Router basename={basename}>
              <Routes />
            </Router>
          </LocationServiceProvider>
        </div>
      )}
      {!loading && error && <div>Location Service not Available</div>}
    </>
  )
}

export default App

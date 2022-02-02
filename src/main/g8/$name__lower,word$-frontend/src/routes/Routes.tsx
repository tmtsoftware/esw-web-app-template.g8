import React from 'react'
import {Route, Routes as RouterRoutes} from 'react-router-dom'
import {NotFound} from '../components/error/NotFound'
import {AdminGreeting} from '../components/pages/AdminGreeting'
import {Greeting} from '../components/pages/Greeting'
import {Welcome} from '../components/pages/Welcome'
import {ProtectedRoute} from './ProtectedRoute'

export const Routes = (): JSX.Element => {
  return (
    <RouterRoutes>
      <Route path='/' element={<Welcome/>}/>
      <Route path='/greeting' element={<Greeting/>}/>
      <ProtectedRoute path='/adminGreeting' element={<AdminGreeting/>}/>
      <Route path='*' element={<NotFound/>}/>
    </RouterRoutes>
  )
}


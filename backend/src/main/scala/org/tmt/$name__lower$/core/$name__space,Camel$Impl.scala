package org.tmt.$name;format="lower"$.core

import org.tmt.$name;format="lower"$.core.models.{AdminGreetResponse, GreetResponse, UserInfo}

import scala.concurrent.Future

class $name;format="space,Camel"$Impl() {
  def greeting(userInfo: UserInfo): Future[GreetResponse] = Future.successful(GreetResponse(userInfo))

  def adminGreeting(userInfo: UserInfo): Future[AdminGreetResponse] =
    Future.successful(AdminGreetResponse(userInfo))
}

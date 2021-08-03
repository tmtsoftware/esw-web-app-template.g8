package org.tmt.$name;format="lower,word"$.impl

import org.tmt.$name;format="lower,word"$.core.models.{AdminGreetResponse, GreetResponse, UserInfo}
import org.tmt.$name;format="lower,word"$.service.$name;format="space,Camel"$Service

import scala.concurrent.Future

class $name;format="space,Camel"$Impl() extends $name;format="space,Camel"$Service{
  def greeting(userInfo: UserInfo): Future[GreetResponse] = Future.successful(GreetResponse(userInfo))

  def adminGreeting(userInfo: UserInfo): Future[AdminGreetResponse] =
    Future.successful(AdminGreetResponse(userInfo))
}

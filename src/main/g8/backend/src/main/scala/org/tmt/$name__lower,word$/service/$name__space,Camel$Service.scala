package org.tmt.$name;format="lower,word"$.service

import org.tmt.$name;format="lower,word"$.core.models.{AdminGreetResponse, GreetResponse, UserInfo}

import scala.concurrent.Future

trait $name;format="space,Camel"$Service {
  def greeting(userInfo: UserInfo): Future[GreetResponse]
  def adminGreeting(userInfo: UserInfo): Future[AdminGreetResponse]
}

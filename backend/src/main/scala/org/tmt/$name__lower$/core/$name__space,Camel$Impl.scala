package org.tmt.$name;format="lower"$.core

import org.tmt.$name;format="lower"$.core.models.{UserInfo, $name;format="space,Camel"$Response}

import scala.concurrent.Future

class $name;format="space,Camel"$Impl() {
  def sayHello(userInfo: UserInfo): Future[$name;format="space,Camel"$Response] = Future.successful($name;format="space,Camel"$Response(s"Hello user: \${userInfo.firstname} \${userInfo.lastname}!!!"))

  def securedSayHello(userInfo: UserInfo): Future[Option[$name;format="space,Camel"$Response]] =
    Future.successful(Some($name;format="space,Camel"$Response(s"Hello secured user: \${userInfo.firstname} \${userInfo.lastname}!!!")))
}

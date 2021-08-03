package org.tmt.$name;format="lower,word"$.http

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import csw.aas.http.AuthorizationPolicy.RealmRolePolicy
import csw.aas.http.SecurityDirectives
import org.tmt.$name;format="lower,word"$.service.$name;format="space,Camel"$Service
import org.tmt.$name;format="lower,word"$.core.models.UserInfo

import scala.concurrent.ExecutionContext

class $name;format="space,Camel"$Route(service1: $name;format="space,Camel"$Service, service2: J$name;format="space,Camel"$ImplWrapper, securityDirectives: SecurityDirectives) (implicit  ec: ExecutionContext) extends HttpCodecs {

 val route: Route = post {
    path("greeting") {
      entity(as[UserInfo]) { userInfo =>
        complete(service1.greeting(userInfo))
      }
    } ~
    path("adminGreeting") {
      securityDirectives.sPost(RealmRolePolicy("Esw-user")) { token =>
        entity(as[UserInfo]) { userInfo => complete(service1.adminGreeting(userInfo)) }
      }
    }
  } ~
    path("sayBye") {
      complete(service2.sayBye())
    }
}


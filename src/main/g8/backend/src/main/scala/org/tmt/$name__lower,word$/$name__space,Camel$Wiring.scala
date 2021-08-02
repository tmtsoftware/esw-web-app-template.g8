package org.tmt.$name;format="lower,word"$

import akka.http.scaladsl.server.Route
import esw.http.template.wiring.ServerWiring
import org.tmt.$name;format="lower,word"$.impl.{J$name;format="space,Camel"$Impl, $name;format="space,Camel"$Impl}
import org.tmt.$name;format="lower,word"$.http.{J$name;format="space,Camel"$ImplWrapper, $name;format="space,Camel"$Route}

class $name;format="space,Camel"$Wiring(val port: Option[Int]) extends ServerWiring {
  override val actorSystemName: String = "$name$-actor-system"

  lazy val j$name;format="space,Camel"$Impl: J$name;format="space,Camel"$Impl = new J$name;format="space,Camel"$Impl(jCswServices)
  lazy val $name;format="space,camel"$Impl               = new $name;format="space,Camel"$Impl()
  lazy val $name;format="space,camel"$ImplWrapper        = new J$name;format="space,Camel"$ImplWrapper(j$name;format="space,Camel"$Impl)

  import actorRuntime.ec
  override lazy val routes: Route = new $name;format="space,Camel"$Route($name;format="space,camel"$Impl, $name;format="space,camel"$ImplWrapper, securityDirectives).route
}

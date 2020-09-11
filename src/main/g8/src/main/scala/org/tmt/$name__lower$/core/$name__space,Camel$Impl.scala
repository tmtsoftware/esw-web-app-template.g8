package org.tmt.$name;format="lower"$.core

import akka.NotUsed
import akka.stream.scaladsl.Source
import csw.location.api.models.Location
import esw.http.template.wiring.CswServices
import org.tmt.$name;format="lower"$.core.models.{Person, $name;format="space,Camel"$Response}

import scala.concurrent.Future
import scala.concurrent.duration.DurationInt

class $name;format="space,Camel"$Impl(cswServices: CswServices) {
  def sayHello(): Future[$name;format="space,Camel"$Response] = Future.successful($name;format="space,Camel"$Response("Hello!!!"))

  def securedSayHello(person: Person): Future[Option[$name;format="space,Camel"$Response]] =
    Future.successful(Some($name;format="space,Camel"$Response(s"Secured Hello!!! \${person.name}")))

  def locations(): Future[List[Location]] = cswServices.locationService.list

  def sayHelloStream(person: Person): Source[$name;format="space,Camel"$Response, NotUsed] = {
    Source.tick(0.seconds, 500.millis, $name;format="space,Camel"$Response("Hello!!! " + person.name)).mapMaterializedValue(_ => NotUsed)
  }
}

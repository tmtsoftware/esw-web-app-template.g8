package org.tmt.$name;format="lower,word"$.http

import org.tmt.$name;format="lower,word"$.impl.J$name;format="space,Camel"$Impl
import org.tmt.$name;format="lower,word"$.core.models.GreetResponse

import scala.jdk.FutureConverters.*
import scala.concurrent.Future

class J$name;format="space,Camel"$ImplWrapper(j$name;format="space,Camel"$Impl: J$name;format="space,Camel"$Impl) {
  def sayBye(): Future[GreetResponse] = j$name;format="space,Camel"$Impl.sayBye().asScala
}

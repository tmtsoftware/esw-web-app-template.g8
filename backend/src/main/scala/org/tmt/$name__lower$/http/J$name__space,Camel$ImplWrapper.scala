package org.tmt.$name;format="lower"$.http

import org.tmt.$name;format="lower"$.impl.J$name;format="space,Camel"$Impl
import org.tmt.$name;format="lower"$.core.models.GreetResponse

import scala.compat.java8.FutureConverters.CompletionStageOps
import scala.concurrent.Future

class J$name;format="space,Camel"$ImplWrapper(j$name;format="space,Camel"$Impl: J$name;format="space,Camel"$Impl) {
  def sayBye(): Future[GreetResponse] = j$name;format="space,Camel"$Impl.sayBye().toScala
}

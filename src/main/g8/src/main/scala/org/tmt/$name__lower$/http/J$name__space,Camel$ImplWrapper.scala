package org.tmt.$name;format="lower"$.http

import org.tmt.$name;format="lower"$.core.J$name;format="space,Camel"$Impl
import org.tmt.$name;format="lower"$.core.models.$name;format="space,Camel"$Response

import scala.compat.java8.FutureConverters.CompletionStageOps
import scala.concurrent.Future

class J$name;format="space,Camel"$ImplWrapper(j$name;format="space,Camel"$Impl: J$name;format="space,Camel"$Impl) {
  def sayBye(): Future[$name;format="space,Camel"$Response] = j$name;format="space,Camel"$Impl.sayBye().toScala
}

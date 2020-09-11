package org.tmt.$name;format="lower"$.core;

import esw.http.template.wiring.JCswServices;
import org.tmt.$name;format="lower"$.core.models.$name;format="space,Camel"$Response;

import java.util.concurrent.CompletableFuture;

public class J$name;format="space,Camel"$Impl {
  JCswServices jCswServices;

  public J$name;format="space,Camel"$Impl(JCswServices jCswServices) {
    this.jCswServices = jCswServices;
  }

  public CompletableFuture<$name;format="space,Camel"$Response> sayBye() {
    return CompletableFuture.completedFuture(new $name;format="space,Camel"$Response("Bye!!!"));
  }

}

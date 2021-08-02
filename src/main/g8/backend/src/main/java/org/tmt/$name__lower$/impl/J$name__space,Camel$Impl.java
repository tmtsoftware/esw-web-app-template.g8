package org.tmt.$name;format="lower"$.impl;

import esw.http.template.wiring.JCswServices;
import org.tmt.$name;format="lower"$.core.models.GreetResponse;

import java.util.concurrent.CompletableFuture;

public class J$name;format="space,Camel"$Impl {
  JCswServices jCswServices;

  public J$name;format="space,Camel"$Impl(JCswServices jCswServices) {
    this.jCswServices = jCswServices;
  }

  public CompletableFuture<GreetResponse> sayBye() {
    return CompletableFuture.completedFuture(new GreetResponse("Bye!!!"));
  }

}

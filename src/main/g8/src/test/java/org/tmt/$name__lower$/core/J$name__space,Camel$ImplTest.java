package org.tmt.$name;format="lower"$.core;

import esw.http.template.wiring.JCswServices;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.scalatestplus.junit.JUnitSuite;
import org.tmt.$name;format="lower"$.core.models.$name;format="space,Camel"$Response;

import java.util.concurrent.ExecutionException;

public class J$name;format="space,Camel"$ImplTest extends JUnitSuite {

  @Test
  public void shouldCallBye() throws ExecutionException, InterruptedException {
    JCswServices mock = Mockito.mock(JCswServices.class);
    J$name;format="space,Camel"$Impl j$name;format="space,Camel"$ = new J$name;format="space,Camel"$Impl(mock);
    $name;format="space,Camel"$Response $name;format="lower"$Response = new $name;format="space,Camel"$Response("Bye!!!");
    Assert.assertThat(j$name;format="space,Camel"$.sayBye().get(), CoreMatchers.is($name;format="lower"$Response));
  }
}

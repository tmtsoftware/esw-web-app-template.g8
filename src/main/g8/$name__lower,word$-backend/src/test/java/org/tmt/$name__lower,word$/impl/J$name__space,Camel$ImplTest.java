package org.tmt.$name;format="lower,word"$.impl;

import esw.http.template.wiring.JCswServices;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.scalatestplus.testng.TestNGSuite;
import org.tmt.$name;format="lower,word"$.core.models.GreetResponse;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;

public class J$name;format="space,Camel"$ImplTest extends TestNGSuite {

  @Test
  public void shouldCallBye() throws ExecutionException, InterruptedException {
    JCswServices mock = Mockito.mock(JCswServices.class);
    J$name;format="space,Camel"$Impl j$name;format="space,Camel"$ = new J$name;format="space,Camel"$Impl(mock);
    GreetResponse greetResponse = new GreetResponse("Bye!!!");
    assertThat(j$name;format="space,Camel"$.sayBye().get(), CoreMatchers.is(greetResponse));
  }
}

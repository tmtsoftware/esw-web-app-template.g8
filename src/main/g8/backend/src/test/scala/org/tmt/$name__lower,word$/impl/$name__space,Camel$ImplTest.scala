package org.tmt.$name;format="lower,word"$.impl

import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.tmt.$name;format="lower,word"$.core.models.{AdminGreetResponse, GreetResponse, UserInfo}

class $name;format="space,Camel"$ImplTest extends AnyWordSpec with Matchers {

  "$name;format="space,Camel"$Impl" must {
    "greeting should return greeting response of 'Hello user'" in {
      val $name;format="space,camel"$Impl = new $name;format="space,Camel"$Impl()
      $name;format="space,camel"$Impl.greeting(UserInfo("John", "Smith")).futureValue should ===(GreetResponse("Hello user: John Smith!!!"))
    }

    "adminGreeting should return greeting response of 'Hello admin user'" in {
      val $name;format="space,camel"$Impl = new $name;format="space,Camel"$Impl()
      $name;format="space,camel"$Impl.adminGreeting(UserInfo("John", "Smith")).futureValue should ===(AdminGreetResponse("Hello admin user: John Smith!!!"))
    }
  }
}

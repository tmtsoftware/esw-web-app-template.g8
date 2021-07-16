package org.tmt.$name;format="lower"$.core

import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.tmt.$name;format="lower"$.core.models.{AdminGreetResponse, GreetResponse, UserInfo}

class $name;format="space,Camel"$ImplTest extends AnyWordSpec with Matchers {

  "$name;format="space,Camel"$Impl" must {
    "greeting should return greeting response of 'Hello user'" in {
      val $name;format="lower"$Impl = new $name;format="space,Camel"$Impl()
      $name;format="lower"$Impl.greeting(UserInfo("John", "Smith")).futureValue should ===(GreetResponse("Hello user: John Smith!!!"))
    }

    "adminGreeting should return greeting response of 'Hello admin user'" in {
      val $name;format="lower"$Impl = new $name;format="space,Camel"$Impl()
      $name;format="lower"$Impl.adminGreeting(UserInfo("John", "Smith")).futureValue should ===(AdminGreetResponse("Hello admin user: John Smith!!!"))
    }
  }
}

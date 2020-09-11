package org.tmt.$name;format="lower"$.core

import esw.http.template.wiring.CswServices
import org.mockito.MockitoSugar.mock
import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.tmt.$name;format="lower"$.core.models.{Person, $name;format="space,Camel"$Response}

class $name;format="space,Camel"$ImplTest extends AnyWordSpec with Matchers {
  val cswServices: CswServices = mock[CswServices]
  val j$name;format="space,Camel"$Impl: J$name;format="space,Camel"$Impl = mock[J$name;format="space,Camel"$Impl]

  "$name;format="space,Camel"$Impl" must {
    "sayHello should return $name;format="lower"$ response of 'Hello!!!'" in {
      val $name;format="lower"$Impl = new $name;format="space,Camel"$Impl(cswServices)
      $name;format="lower"$Impl.sayHello().futureValue should ===($name;format="space,Camel"$Response("Hello!!!"))
    }

    "securedSayHello should return $name;format="lower"$ response of 'Secured Hello!!!'" in {
      val $name;format="lower"$Impl = new $name;format="space,Camel"$Impl(cswServices)
      $name;format="lower"$Impl.securedSayHello(Person("John")).futureValue should ===(Some($name;format="space,Camel"$Response("Secured Hello!!! John")))
    }
  }
}

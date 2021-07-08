package org.tmt.$name;format="lower"$.core

import esw.http.template.wiring.CswServices
import org.mockito.MockitoSugar.mock
import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.tmt.$name;format="lower"$.core.models.{UserInfo, $name;format="space,Camel"$Response}

class $name;format="space,Camel"$ImplTest extends AnyWordSpec with Matchers {
  val cswServices: CswServices = mock[CswServices]
  val j$name;format="space,Camel"$Impl: J$name;format="space,Camel"$Impl = mock[J$name;format="space,Camel"$Impl]

  "$name;format="space,Camel"$Impl" must {
    "sayHello should return $name;format="lower"$ response of 'Hello!!!'" in {
      val $name;format="lower"$Impl = new $name;format="space,Camel"$Impl(cswServices)
      $name;format="lower"$Impl.sayHello(UserInfo("John", "Smith")).futureValue should ===($name;format="space,Camel"$Response("Hello user: John Smith!!!"))
    }

    "securedSayHello should return $name;format="lower"$ response of 'Secured Hello!!!'" in {
      val $name;format="lower"$Impl = new $name;format="space,Camel"$Impl(cswServices)
      $name;format="lower"$Impl.securedSayHello(UserInfo("John", "Smith")).futureValue should ===(Some($name;format="space,Camel"$Response("Hello secured user: John Smith!!!")))
    }
  }
}

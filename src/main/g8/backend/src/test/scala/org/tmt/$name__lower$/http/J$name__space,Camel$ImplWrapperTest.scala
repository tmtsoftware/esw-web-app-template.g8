package org.tmt.$name;format="lower"$.http

import java.util.concurrent.CompletableFuture

import org.mockito.MockitoSugar.{mock, verify, when}
import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.tmt.$name;format="lower"$.impl.J$name;format="space,Camel"$Impl
import org.tmt.$name;format="lower"$.core.models.GreetResponse

class J$name;format="space,Camel"$ImplWrapperTest extends AnyWordSpec with Matchers {

  "$name;format="space,Camel"$ImplWrapper" must {
    "delegate sayBye to J$name;format="space,Camel"$Impl.sayBye" in {
      val j$name;format="space,Camel"$Impl       = mock[J$name;format="space,Camel"$Impl]
      val $name;format="lower"$ImplWrapper = new J$name;format="space,Camel"$ImplWrapper(j$name;format="space,Camel"$Impl)

      val $name;format="lower"$Response = mock[GreetResponse]
      when(j$name;format="space,Camel"$Impl.sayBye()).thenReturn(CompletableFuture.completedFuture($name;format="lower"$Response))

      $name;format="lower"$ImplWrapper.sayBye().futureValue should ===($name;format="lower"$Response)
      verify(j$name;format="space,Camel"$Impl).sayBye()
    }
  }
}

package org.tmt.$name;format="lower,word"$.http

import java.util.concurrent.CompletableFuture

import org.mockito.Mockito.{verify, when}
import org.scalatestplus.mockito.MockitoSugar.mock
import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.tmt.$name;format="lower,word"$.impl.J$name;format="space,Camel"$Impl
import org.tmt.$name;format="lower,word"$.core.models.GreetResponse

class J$name;format="space,Camel"$ImplWrapperTest extends AnyWordSpec with Matchers {

  "$name;format="space,Camel"$ImplWrapper" must {
    "delegate sayBye to J$name;format="space,Camel"$Impl.sayBye" in {
      val j$name;format="space,Camel"$Impl       = mock[J$name;format="space,Camel"$Impl]
      val $name;format="space,camel"$ImplWrapper = new J$name;format="space,Camel"$ImplWrapper(j$name;format="space,Camel"$Impl)

      val $name;format="space,camel"$Response = mock[GreetResponse]
      when(j$name;format="space,Camel"$Impl.sayBye()).thenReturn(CompletableFuture.completedFuture($name;format="space,camel"$Response))

      $name;format="space,camel"$ImplWrapper.sayBye().futureValue should ===($name;format="space,camel"$Response)
      verify(j$name;format="space,Camel"$Impl).sayBye()
    }
  }
}

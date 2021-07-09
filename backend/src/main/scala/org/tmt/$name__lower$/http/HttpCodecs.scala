package org.tmt.$name;format="lower"$.http

import csw.location.api.codec.LocationCodecs
import io.bullet.borer.Codec
import io.bullet.borer.compat.AkkaHttpCompat
import io.bullet.borer.derivation.MapBasedCodecs.deriveCodec
import org.tmt.$name;format="lower"$.core.models.{UserInfo, $name;format="space,Camel"$Response}

object HttpCodecs extends HttpCodecs

trait HttpCodecs extends AkkaHttpCompat with LocationCodecs {
  implicit lazy val $name;format="lower"$ResponseCodec: Codec[$name;format="space,Camel"$Response] = deriveCodec
  implicit lazy val userInfoCodec: Codec[UserInfo]                 = deriveCodec
}

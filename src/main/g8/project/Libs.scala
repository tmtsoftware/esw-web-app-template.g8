import sbt._

object Libs {
  val `esw-http-template-wiring` = "com.github.tmtsoftware.esw" %% "esw-http-template-wiring" % "$esw_version$"

  //testing
  val `akka-http-testkit`        = "com.typesafe.akka"                        %% "akka-http-testkit"        % "10.2.0"
  val `akka-actor-testkit-typed` = "com.typesafe.akka"                        %% "akka-actor-testkit-typed" % "2.6.9"
  val `akka-stream-testkit`      = "com.typesafe.akka"                        %% "akka-stream-testkit"      % "2.6.9"
  val `embedded-keycloak`        = "com.github.tmtsoftware.embedded-keycloak" %% "embedded-keycloak"        % "0.2.0-M1"
  val `mockito-scala`            = "org.mockito"                              %% "mockito-scala"            % "1.15.0"
  val `scalatest`                = "org.scalatest"                            %% "scalatest"                % "3.2.2"
}

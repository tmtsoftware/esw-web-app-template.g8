name := "$name;format="lower"$"

version := "$version$"

scalaVersion := "2.13.5"

resolvers += "jitpack" at "https://jitpack.io"
fork := true
run / javaOptions += "-Dcsw-networks.hostname.automatic=on"

libraryDependencies ++= Seq(
  Libs.`esw-http-template-wiring` % "compile->compile;test->test",
  Libs.`embedded-keycloak`        % Test,
  Libs.`scalatest`                % Test,
  Libs.`akka-http-testkit`        % Test,
  Libs.`mockito-scala`            % Test,
  Libs.`akka-actor-testkit-typed` % Test,
  Libs.`akka-stream-testkit`      % Test
)

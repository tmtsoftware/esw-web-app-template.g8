lazy val `$name$-backend` = project
  .in(file("."))
  .aggregate(`ignore`)
  .settings(
    inThisBuild(
      List(
        scalaVersion := "2.13.6",
        version := "$version$"
      )
    ),
    name := "$name$-backend",
    fork := true,
    resolvers += "jitpack" at "https://jitpack.io",
    libraryDependencies ++= Seq(
      Libs.`esw-http-template-wiring` % "compile->compile;test->test",
      Libs.`embedded-keycloak`        % Test,
      Libs.`scalatest`                % Test,
      Libs.`akka-http-testkit`        % Test,
      Libs.`mockito`                  % Test,
      Libs.`akka-actor-testkit-typed` % Test,
      Libs.`akka-stream-testkit`      % Test
    ),
    Test / fork := true
  )

lazy val `ignore` = project.in(file(".ignore"))

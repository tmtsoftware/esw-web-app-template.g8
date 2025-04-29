lazy val `$name$-backend` = project
  .in(file("."))
  .aggregate(`ignore`)
  .settings(
    inThisBuild(
      List(
        scalaVersion := "3.6.4",
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
      Libs.`pekko-http-testkit`        % Test,
      Libs.`mockito` % Test,
      Libs.`junit4-interface` % Test,
      Libs.`testng-6-7` % Test,
      Libs.`pekko-actor-testkit-typed` % Test,
      Libs.`pekko-stream-testkit`      % Test
    ),
    Test / fork := true
  )

lazy val `ignore` = project.in(file(".ignore"))

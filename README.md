This is a Giter8 template for a TMT backend which creates a sample sbt project.

The created project contains a sample backend application which includes the following :

* Server wiring along which has handles of all csw services (SampleWiring.scala)
* Backend routes for various use cases (SampleRoute.scala)
* Sample Api and its implementation for both scala and java (SampleImpl.scala, JSampleImpl.java, JSampleImplWrapper.scala)
* Models and their (de)Serialization using borer (HttpCodecs.scala)
* A case app for starting server with `start` command (SampleApp.scala)
* Unit tests, integration tests for the backend server.


This template will prompt for the following parameters. Press Enter to accept the default values, shown in brackets:

* name [sample]: The name of the project.
* description [sample] : The Component Name of the Assembly
* prefix [ESW.sample] : The prefix of the backend application.
* organization [org.tmt]: Specifies the organization for this project.
* version [0.0.1]: Specifies the version for this project.
* package [org.tmt.ESW.sample]: Top level package which dynamically gets created based on provided organization and subsystem in all subprojects.
* scala_version [2.13.1]: Specifies the Scala version for this project.
* esw_version [c5690d3]: Specifies the Executive Software (CSW) version for this project

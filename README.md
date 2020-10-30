This is a Giter8 template for a TMT backend which creates a sample sbt project.

The created project contains a sample backend application which includes the following :

* Server wiring along which has handles of all csw services (SampleWiring.scala)
* Backend routes for various use cases (SampleRoute.scala)
* Sample Api and its implementation for both scala and java (SampleImpl.scala, JSampleImpl.java, JSampleImplWrapper.scala)
* Models and their (de)Serialization using borer (HttpCodecs.scala)
* A case app for starting server with `start` command (SampleApp.scala)
* Unit tests, integration tests for the backend server.

## Getting Started

### Install Coursier
Please follow the [coursier installation](https://get-coursier.io/docs/cli-installation)

### Install Giter8

`cs install giter8`

### Create new project using giter8 template

`g8 tmtsoftware/esw-backend-template.g8 -t v0.1.0-M1`

This template will prompt for the following parameters. Press Enter to accept the default values, shown in brackets:

* name: The name of the project.
* organization: Specifies the organization for this project.
* prefix: The prefix of the backend application.
* version: Specifies the version for this project.
* package: Top level package which dynamically gets created based on provided organization and subsystem in all subprojects.
* scala_version: Specifies the Scala version for this project.
* esw_version: Specifies the Executive Software (ESW) version for this project

Once the project is generated, refer to project's README for instructions on how to use, build, and run the project.


---
**NOTE**
Following section is intended only for testing purpose and can be skipped by the consumers of template.
---
#### Testing the template

For people interested in testing the template with latest commit on main branch, refer [testing.md](./testing.md)

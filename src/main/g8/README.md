# $name$

This project implements a sample http server based application using
TMT Executive Software ([ESW](https://github.com/tmtsoftware/esw)) APIs.

## Build Instructions

The build is based on sbt and depends on libraries generated from the
[ESW](https://github.com/tmtsoftware/esw) project.

See [here](https://www.scala-sbt.org/1.0/docs/Setup.html) for instructions on installing sbt.

## Prerequisites for running App

The CSW Auth service needs to be running before starting the components.
This is done by starting the `csw-services.sh` script which is present inside `scripts` directory in CSW project.
Follow below instructions to run Auth service:

* Run `./scripts/csw-services.sh start -k` command to start auth service.
* Run `./csw_services.sh start --help` to get more information.

## Running the App

Before we start the app we need to set the following env variables:
* PUBLIC_INTERFACE_NAME
* TMT_LOG_HOME
* INTERFACE_NAME

To start the app:
`sbt "run start"`



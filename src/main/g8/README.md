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

To start the app run:
`sbt "run start"`
This will start the app with default port 8080. 

If you want to start the app at custom port,
run `sbt "run start -p <port number>`

## How to use the project
```bash
.
├── src
│   ├── main
│   │   ├── java
│   │   └── scala
```
* The template generates implementations for both Java and Scala. Both are not required to develop the app. 
After you choose which language you want to develop in, you can delete the other. We encourage you to use Scala! 
It has good support for asynchronous programming.

* The routes can be added in [$name;format="Camel"$Route](./src/main/scala/org/tmt/$name;format="lower"$/http/$name;format="Camel"$Route.scala).
Some example routes are already available.

* For adding new auth policy to your routes, the policy must be added to `securityDirectives` while defining the route.
For example, if you want to add policy such that only `esw-admin` should be able to access some route, then it could be done as shown
in below snippet. More information about auth policies can be found at [docs](https://tmtsoftware.github.io/csw/services/aas/csw-aas-http.html#authorization-policies).
```
   path("endpoint") {
        securityDirectives.sPost(RealmRolePolicy("Esw-admin")) {
            // process request
        }
   }
```

* API implementation can be added in [$name;format="Camel"$Impl](./src/main/scala/org/tmt/$name;format="lower"$/core/$name;format="Camel"$Impl.scala).
Implementation for the example routes are already available. If java is the preferred language then the implementation
can be added as shown in [J$name;format="Camel"$Impl](./src/main/java/org/tmt/$name;format="lower"$/core/J$name;format="Camel"$Impl.java). In this case, impl conversion
to scala should be done as shown in [J$name;format="Camel"$ImplWrapper](./src/main/scala/org/tmt/$name;format="lower"$/http/J$name;format="Camel"$ImplWrapper.scala)

* Core models for supporting the APIs should be added in [models](./src/main/scala/org/tmt/$name;format="lower"$/core/models) package.
Codecs for these models should be added in [HttpCodecs](./src/main/scala/org/tmt/$name;format="lower"$/http/HttpCodecs.scala).

* [$name;format="Camel"$Wiring](./src/main/scala/org/tmt/$name;format="lower"$/$name;format="Camel"$Wiring.scala) is where we wire up our implementation with our routes.

* [$name;format="Camel"$App](./src/main/scala/org/tmt/$name;format="lower"$/$name;format="Camel"$App.scala) is the main runnable application. The command line arguments 
for starting the app are defined in [$name;format="Camel"$AppCommand](./src/main/scala/org/tmt/$name;format="lower"$/$name;format="Camel"$AppCommand.scala). Any new command  
or option for command can be added like so:
```
 @CommandName("<command_name>")
  final case class <command_name>(
     @HelpMessage("<help message>")
     @ExtraName("<option>")
     option: <type>
   ) extends SampleAppCommand
```
* The newly added command/options need to handled in $name;format="Camel"$App

* Any new application specific configuration can be added in [application.conf](./src/main/resources/application.conf)

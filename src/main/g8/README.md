# $name$

This project implements a sample HTTP server-based application using
TMT Executive Software ([ESW](https://github.com/tmtsoftware/esw)) APIs.

## Build Instructions

The build is based on sbt and depends on libraries generated from the
[ESW](https://github.com/tmtsoftware/esw) project.

See [here](https://www.scala-sbt.org/1.0/docs/Setup.html) for instructions on installing sbt.

## Prerequisites for Running App

The CSW AAS Service needs to be running before starting the components.
Follow below instructions to run AAS:

```
cs install csw-services:<version>
csw-services start --auth
```
NOTE: version should be the appropriate [CSW release](https://github.com/tmtsoftware/csw/releases) for the ESW version used in this project ($esw_version$).

This will start AAS.
You can run `csw-services start --help` to get more information.

## Running the App

Before we start the app we need to set the following environment variables:
* INTERFACE_NAME
* PUBLIC_INTERFACE_NAME
* TMT_LOG_HOME

To set environment variables, use the command `export <ENV_VAR> = <VALUE>`

For development, the `INTERFACE_NAME` and `PUBLIC_INTERFACE_NAME` can be set as the primary machine 
interface name. For example, `en0`.  See the CSW documention on [Network Topology](http://tmtsoftware.github.io/csw/deployment/network-topology.html) for more information.

To start the app, run:
`sbt "run start"`
This will start the app with default port 8080. 

If you want to start the app at custom port,
run `sbt "run start -p <port number>`

You can verify whether the application has started successfully by using the endpoint in `apptest.http` (e.g. using `curl`).

NOTE: `<host>` needs to be replaced by the host address where app is running. Port also needs to be changed 
if custom one is used.

## How to Use the Project
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

* For adding a new authorization policy to your routes, the policy must be added to `securityDirectives` while defining the route.
For example, if you want to add policy such that only `esw-admin` should be able to access some route, then it could be done as shown
in below snippet. More information about authorization policies can be found in the  [AAS documentation](https://tmtsoftware.github.io/csw/services/aas/csw-aas-http.html#authorization-policies).
```
   path("endpoint") {
        securityDirectives.sPost(RealmRolePolicy("Esw-admin")) {
            // process request
        }
   }
```

* The API implementation can be added in [$name;format="Camel"$Impl](./src/main/scala/org/tmt/$name;format="lower"$/core/$name;format="Camel"$Impl.scala).
This template provides some routes that serve as examples. If Java is your preferred language, then the implementation
can be added as shown in [J$name;format="Camel"$Impl](./src/main/java/org/tmt/$name;format="lower"$/core/J$name;format="Camel"$Impl.java). In this case, a Scala
is required, as shown in [J$name;format="Camel"$ImplWrapper](./src/main/scala/org/tmt/$name;format="lower"$/http/J$name;format="Camel"$ImplWrapper.scala)

* Core models for supporting the APIs should be added in the [models](./src/main/scala/org/tmt/$name;format="lower"$/core/models) package.
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
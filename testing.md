# Testing latest template

To test latest `esw-backend-template`:

1. Take latest pull of `esw` repository
2. In `esw` repository, run `sbt publishLocal`
3. Generate project using command `g8 tmtsoftware/esw-backend-template.g8`
4. In the generated project, tests can be run using `sbt clean test`

If you want to run the sample app, you need to start `csw-services` with the version that is being used in the 
`esw` repository on your machine.

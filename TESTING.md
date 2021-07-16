# Testing latest template

To test latest `esw-backend-template`:

1. Take latest pull of `esw` repository
2. In `esw` repository, run `sbt publishLocal`
3. Generate project using command `g8 tmtsoftware/web-app-template.g8 --branch dev`

## Backend Project

1. In the generated project, go to backend project using `cd backend`
2. Tests can be run using `sbt clean test`

## Frontend Project

1. In the generated project, go to frontend project using `cd frontend`
2. Tests can be run using `npm test`

If you want to run the backend and frontend app, you need to start `csw-services` with the version that is being used in the `esw` repository on your machine.

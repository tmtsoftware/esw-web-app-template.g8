# Releasing

Steps to release:

1. Update `esw` version in `src/main/g8/project/Libs.scala`
1. Update new `esw-backend-template` release version in [README.md](./README.md#create-new-project-using-giter8-template)
1. Update `embedded-keycloak` version in `src/main/g8/project/Libs.scala`
1. Make sure `dev` workflow is green in actions tab in github repo
1. Update `release.yml`
    Update step `Giter8 Compile` in `release.yml`
    Update `<****>` in `g8 tmtsoftware/esw-backend-template.g8 -t <****> --name=http-server` with esw-backend-template.g8 version that you are going to release
    
    For example, if you are going to release `v3.0.0` of `esw-backend-template.g8`
    then updated line in `release.yml` will look like `g8 tmtsoftware/esw-backend-template.g8 -t v3.0.0 --name=http-server`
1. Run `./release.sh $VERSION$` script by providing version number argument
    **Note:** `PROD=true` environment variable needs to be set before running `release.sh`
1. Tagging esw-backend-template.g8 will trigger `release` workflow in github actions tab. Make sure that `release` workflow is green.
1. After release is complete, change the `esw` version back to `0.1.0-SNAPSHOT` in `src/main/g8/project/Libs.scala`
1. After release is complete, update step `Giter8 Compile` in `release.yml`:

   Replace the tag version in `release.yml` version with `<****>`
   Like this, `g8 tmtsoftware/esw-backend-template.g8 -t <****> --name=http-server`

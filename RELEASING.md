# Releasing

Steps to release:

1. Change `esw` version in `src/main/g8/default.properties` and `README.md`
1. Make sure `dev` workflow is green in actions tab in github repo
1. Update `release.yml`
    Update step `Giter8 Compile` in `release.yml`
    Update `<****>` in `g8 tmtsoftware/esw-backend-template.g8 -t <****> --name=galil` with esw-backend-template.g8 version that you are going to release
    
    For example, if you are going to release `v3.0.0` of `esw-backend-template.g8`
    then updated line in `release.yml` will look like `g8 tmtsoftware/esw-backend-template.g8 -t v3.0.0 --name=galil`
1. Run `./release.sh $VERSION$` script by providing version number argument
    **Note:** `PROD=true` environment variable needs to be set before running `release.sh`
1. Tagging esw-backend-template.g8 will trigger `release` workflow in github actions tab. Make sure that `release` workflow is green.

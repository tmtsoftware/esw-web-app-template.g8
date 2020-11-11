# Releasing

Steps to release:

1. Update `esw` and `embedded-keycloak` version in `src/main/g8/project/Libs.scala` in dev branch
1. Make sure workflow is green in actions tab in github repo for dev branch
1. Rebase dev branch with master branch
1. Merge dev branch to master branch
1. Make sure workflow is green in actions tab in github repo for master branch
1. Run `./release.sh $VERSION$` script by providing version number argument
   **Note:** `PROD=true` environment variable needs to be set before running `release.sh`
1. After release is complete, change the `esw` version back to `0.1.0-SNAPSHOT` in `src/main/g8/project/Libs.scala` in dev branch

**Note:** Tagging csw.g8 will again trigger `release` workflow in github actions tab. This will help in release status lookup
in the future.

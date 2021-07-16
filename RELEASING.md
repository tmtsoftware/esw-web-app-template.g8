# Releasing

Steps to release:

1. Go to frontend folder
2. Change `esw-ts` version in `package.json`
3. Go to backend folder
4. Update `esw` and `embedded-keycloak` version in `project/Libs.scala` in `dev` branch
5. Commit and push changes to `dev` branch
6. Make sure `dev` workflow is green in actions tab in github repo
7. Rebase dev branch with master branch
8. Merge dev branch to master branch
9. Make sure workflow is green in actions tab in github repo for `master` branch
10. Run ./release.sh `VERSION` script by providing version number argument
    **Note:** `PROD=true` environment variable needs to be set before running `release.sh`
11. After release is complete, change the `esw` version back to `0.1.0-SNAPSHOT` in `project/Libs.scala` in dev branch
12. Tagging esw-web-app-template.g8 will trigger `release` workflow in github actions tab. Make sure that `release` workflow is green

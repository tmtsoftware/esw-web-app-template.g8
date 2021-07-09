# Releasing

Steps to release:

1. Change `esw-ts` version in `package.json`
1. Commit and push changes to `dev` branch
1. Make sure `dev` workflow is green in actions tab in github repo
1. Rebase dev branch with master branch
1. Merge dev branch to master branch
1. Make sure workflow is green in actions tab in github repo for master branch
1. Run ./release.sh <VERSION> script by providing version number argument
    **Note:** `PROD=true` environment variable needs to be set before running `release.sh`

1. Tagging esw-ui-template.g8 will trigger `release` workflow in github actions tab. Make sure that `release` workflow is green

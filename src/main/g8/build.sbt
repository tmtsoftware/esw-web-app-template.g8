import org.tmt.sbt.docs.Settings
import org.tmt.sbt.docs.DocKeys._

lazy val githubRepoUrl = "https://github.com/your-username/your-project"

ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organizationName := "TMT Org"
ThisBuild / docsRepo := githubRepoUrl
ThisBuild / docsParentDir := ""
ThisBuild / gitCurrentRepo := githubRepoUrl

version := {
  sys.props.get("prod.publish") match {
    case Some("true") => version.value
    case _            => "0.1.0-SNAPSHOT"
  }
}

lazy val openSite =
  Def.setting {
    Command.command("openSite") { state =>
      val uri = s"file://\${Project.extract(state).get(siteDirectory)}/\${docsParentDir.value}/\${version.value}/index.html"
      state.log.info(s"Opening browser at \$uri ...")
      java.awt.Desktop.getDesktop.browse(new java.net.URI(uri))
      state
    }
  }



/* ================= Root Project ============== */
lazy val `$name;format="norm"$` = project
  .in(file("."))
  .enablePlugins(GithubPublishPlugin)
  .aggregate(docs)
  .settings(
    ghpagesBranch := "gh-pages", // DO NOT DELETE
    commands += openSite.value,
    Settings.makeSiteMappings(docs)
  )

/* ================= Paradox Docs ============== */
lazy val docs = project
  .enablePlugins(ParadoxMaterialSitePlugin)
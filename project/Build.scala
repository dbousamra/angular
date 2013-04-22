import sbt._
import Keys._
import play.Project._
import com.gu.SbtJasminePlugin._
import sbtjslint.Plugin._
import sbtjslint.Plugin.LintKeys._


object ApplicationBuild extends Build {

  val appName         = "angular"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    "com.typesafe.play" %% "play-slick" % "0.3.2"
  )
  
  val localSettings = lintSettings ++ inConfig(Compile)(Seq(
    // jslint
    sourceDirectory in jslint <<= (baseDirectory)(_ / "app/assets/javascripts"),
    excludeFilter in jslint := "generated" || "lib",
    flags in jslint := Seq("sloppy", "continue", "vars", "nomen")
))

  val main = play.Project(appName, appVersion, appDependencies)
    .settings(jasmineSettings : _*)
    .settings(localSettings : _*)
    .settings(
      routesImport += "se.radley.plugin.salat.Binders._",
      templatesImport += "org.bson.types.ObjectId")
    .settings(
      appJsDir <+= baseDirectory / "app/assets/javascripts",
      appJsLibDir <+= baseDirectory / "public/javascripts/lib",
      jasmineTestDir <+= baseDirectory / "test/assets/",
      jasmineConfFile <+= baseDirectory / "test/assets/test.dependencies.js"
  )
}

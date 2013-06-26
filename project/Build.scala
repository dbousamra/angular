import sbt._
import Keys._
import play.Project._
import sbtjslint.Plugin._
import sbtjslint.Plugin.LintKeys._


object ApplicationBuild extends Build {

  val appName         = "angular"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    "com.typesafe.play" %% "play-slick" % "0.3.2",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.1.3"
  )
  
  val localSettings = lintSettings ++ inConfig(Compile)(Seq(
    sourceDirectory in jslint <<= (baseDirectory)(_ / "app/assets/javascripts"),
    excludeFilter in jslint := "generated" || "lib",
    flags in jslint := Seq("sloppy", "continue", "vars", "nomen")
))

  val main = play.Project(appName, appVersion, appDependencies)
    .settings(localSettings : _*)
}

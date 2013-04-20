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
    anorm
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
    // Add your own project settings here

    // jasmine configuration, overridden as we don't follow the default project structure sbt-jasmine expects
    appJsDir <+= baseDirectory / "app/assets/javascripts",
    appJsLibDir <+= baseDirectory / "public/javascripts/lib",
    jasmineTestDir <+= baseDirectory / "test/assets/",
    jasmineConfFile <+= baseDirectory / "test/assets/test.dependencies.js"
    // link jasmine to the standard 'sbt test' action. Now when running 'test' jasmine tests will be run, and if they pass
    // then other Play tests will be executed.
//    (test in Test) <<= (test in Test) dependsOn (jasmine)
  )
}

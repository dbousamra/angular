import sbt._
import Keys._
import play.Project._


object ApplicationBuild extends Build {

  val appName         = "angular"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    "com.typesafe.play" %% "play-slick" % "0.3.2",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.1.3"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Allow all the specified commands below to be run within sbt
    commands <++= baseDirectory { base =>
      Seq(
        "bower"
      ).map(cmd(_, base))
    }
  )

  private def cmd(name: String, base: File): Command = {
    Command.args(name, "<" + name + "-command>") { (state, args) =>
      Process(name :: args.toList, base) !;
      state
    }
  }
}
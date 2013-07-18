import sbt._
import Keys._
import play.Project._
import net.litola.SassPlugin //import sass plugin
import net.litola.SassPlugin._ //import sass plugin


object ApplicationBuild extends Build {

  val appName         = "SassCompassDemo"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    SassPlugin.sassSettings(0),
    SassPlugin.sassOptions := Seq("--compass","-r", "compass", "-r"),
    SassPlugin.sassSettings(2),
    resourceGenerators in Compile <+= SassPlugin.sassWatcher
  )//.settings( SassPlugin.sassSettings:_*).settings( SassPlugin.sassOptions := Seq("--compass","-r", "compass","-g") )

}

import sbt._
import Keys._
import play.Project._
import net.litola.SassPlugin //import sass plugin 


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
  ).settings( SassPlugin.sassSettings:_*).settings( SassPlugin.sassOptions := Seq("--compass","-r", "compass","-g") )

}

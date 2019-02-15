

// SBT
import sbt._
import Keys._

// Scalafmt plugin




object BuildSettings {

  lazy val compilerOptions = Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-unused-import",
    "-Xfuture",
    "-Xlint"
  )

  lazy val javaCompilerOptions = Seq(
    "-source", "1.8",
    "-target", "1.8"
  )

  // scoverage settings
  import scoverage.ScoverageSbtPlugin.autoImport._

  lazy val scoverageSettings = Seq(
    coverageMinimum := 60,
    coverageFailOnMinimum := true,
    coverageExcludedPackages := List(
      "com.capitalone.cep.generated.*"
    ).mkString(";")
  )
  
  // sbt-assembly settings for building a fat jar
  import sbtassembly.AssemblyPlugin.autoImport._
  lazy val sbtAssemblySettings = Seq(
    assemblyJarName in assembly := { s"${moduleName.value}-${version.value}.jar" },
    assemblyMergeStrategy in assembly := {
      case PathList("reference.conf") => MergeStrategy.concat
      case PathList(ps @ _*) if ps.last endsWith ".html"=> MergeStrategy.discard
      case PathList(ps @ _*) if ps.last endsWith "LICENSE"=> MergeStrategy.discard
      case PathList("META-INF", xs @ _*) =>
        (xs map {_.toLowerCase}) match {
          case "services" :: xs =>
            MergeStrategy.filterDistinctLines
          case _ => MergeStrategy.discard
        }
      case PathList("mozilla", xs@_*) => MergeStrategy.discard
      case PathList("webapps", xs@_*) => MergeStrategy.discard
      case PathList("rest-management-private-classpath", xs@_*) => MergeStrategy.discard
      case PathList("org", "apache", "hadoop", xs@_*) => MergeStrategy.discard
      case x => MergeStrategy.first
      
    }
    
  )
  import org.scalafmt.sbt.ScalafmtPlugin.autoImport._

  lazy val scalaFmtSettings = Seq(
    scalafmtOnCompile := true
  )
  


  lazy val addExampleConfToTestCp = Seq(
    unmanagedClasspath in Test += baseDirectory.value.getParentFile / "examples"
  )
}

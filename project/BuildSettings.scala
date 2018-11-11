

// SBT
import sbt._
import Keys._

// Scalafmt plugin
import com.lucidchart.sbt.scalafmt.ScalafmtPlugin._
import com.lucidchart.sbt.scalafmt.ScalafmtCorePlugin.autoImport._

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

  // sbt-assembly settings for building a fat jar
  import sbtassembly.AssemblyPlugin.autoImport._
  lazy val sbtAssemblySettings = Seq(
    assemblyJarName in assembly := { s"${moduleName.value}-${version.value}.jar" }
  )
  lazy val formatting = Seq(
    scalafmtConfig    := file(".scalafmt.conf"),
    scalafmtOnCompile := true,
    scalafmtVersion   := "1.3.0"
  )

  lazy val addExampleConfToTestCp = Seq(
    unmanagedClasspath in Test += baseDirectory.value.getParentFile / "examples"
  )
}

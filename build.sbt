name := "SbtScafolded"

version := "0.1"




lazy val commonDependencies = Seq(
  // Java
  Dependencies.Libraries.yodaTime,
  Dependencies.Libraries.slf4j,
  Dependencies.Libraries.log4jOverSlf4j,
  Dependencies.Libraries.config,
  // Scala
  Dependencies.Libraries.scalaz7,
  Dependencies.Libraries.json4sJackson,
  Dependencies.Libraries.pureconfig,
  // Scala (test)

  Dependencies.Libraries.specs2
)

lazy val buildSettings = Seq(
  organization  :=  "com.paropakar",
  name          :=  "sbt-scafolded-app",
  version       :=  "0.0.1",
  description   :=  "Scafolded app which can be leveraged for building ",
  scalaVersion  :=  "2.11.11",
  scalacOptions :=  BuildSettings.compilerOptions,
  scalacOptions in (Compile, console) ~= { _.filterNot(Set("-Ywarn-unused-import")) },
  scalacOptions in (Test, console)    := (scalacOptions in (Compile, console)).value,
  javacOptions  :=  BuildSettings.javaCompilerOptions

)

lazy val allSettings = buildSettings ++
  BuildSettings.sbtAssemblySettings ++
  Seq(libraryDependencies ++= commonDependencies)

lazy val root = project.in(file("."))
  .settings(buildSettings)
  .aggregate(core)

lazy val core = project
  .settings(moduleName := "sbt-scafolded-app")
  .settings(buildSettings)
  .settings(libraryDependencies ++= commonDependencies)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](organization, name, version, "shortName" -> "ssc"),
    buildInfoPackage := "com.paropakar"
  )





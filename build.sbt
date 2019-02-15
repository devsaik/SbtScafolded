name := "SbtScafolded"

version := "0.1"




lazy val commonDependencies = Seq(
  // Java
  Dependencies.Libraries.yodaTime,
  Dependencies.Libraries.logback,
  Dependencies.Libraries.sl4j,
  Dependencies.Libraries.logging,
  Dependencies.Libraries.config,
  // Scala
  Dependencies.Libraries.json4sJackson,
  Dependencies.Libraries.pureconfig,
  // Scala (test)
  Dependencies.Libraries.scalaTest,
  Dependencies.Libraries.specs2
)

lazy val buildSettings = Seq(
  organization  :=  "com.wellpay",
  name          :=  "sbt-scafolded",
  version       :=  "0.0.1",
  description   :=  "Scafolded app to build microservices ",
  scalaVersion  :=  "2.12.4",
  scalacOptions :=  BuildSettings.compilerOptions,
  scalacOptions in (Compile, console) ~= { _.filterNot(Set("-Ywarn-unused-import")) },
  scalacOptions in (Test, console)    := (scalacOptions in (Compile, console)).value,
  javacOptions  :=  BuildSettings.javaCompilerOptions,
  resolvers     ++= Dependencies.resolutionRepos

)

lazy val allSettings = buildSettings ++
  BuildSettings.sbtAssemblySettings ++
  Seq(libraryDependencies ++= commonDependencies)

lazy val root = project.in(file("."))
  .settings(allSettings)
  .aggregate(core)

lazy val core = project
  .settings(moduleName := "sbt-scafolded")
  .settings(buildSettings)
  .settings(libraryDependencies ++= commonDependencies)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](organization, name, version, "shortName" -> "ssc"),
    buildInfoPackage := "com.wellpay"
  )





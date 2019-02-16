name := "Sbtscaffolded"

version := "0.1"




lazy val commonDependencies = Seq(
  // Java
  Dependencies.Libraries.yodaTime,
  Dependencies.Libraries.logback,
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
  name          :=  "sbt-scaffolded",
  version       :=  "0.0.1",
  description   :=  "scaffolded app to build microservices ",
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




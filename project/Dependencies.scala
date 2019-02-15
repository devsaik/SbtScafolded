
import sbt._

object Dependencies {

  val resolutionRepos = Seq(
    
   // "Local Maven Repository" at "file:///" + Path.userHome.absolutePath + "/.m2/repository",
    //"Local Ivy Repository" at "file:///"+ Path.userHome.absolutePath + "/.ivy2/local",
    Resolver.url( "Maven releases", new URL("https://mvnrepository.com/artifact")),//( Patterns("[organization]/[module]/[module]-[revision].[ext]") ), 
    "TypeSafe Ivy releases"  at "https://repo.typesafe.com/typesafe/releases",
    "sbtPlugin repo " at "https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases",
    "JavaNet1Repository" at "http://download.java.net/maven/1/"
    

  )
  

  object V {
    // Java
   
    val yodaTime             = "2.9.9"
    val slf4j                = "1.7.25"
    val logback              = "1.2.3"
    val logging              = "3.7.2"
    val config               = "1.3.1"
    // Scala
  
    val scalaz7              = "7.0.9"
    val json4s               = "3.2.11"
    val pureconfig           = "0.8.0"
    // Scala (test only)
    val specs2               = "3.9.4"
    val scalaTest            =   "3.0.5"
  }

  object Libraries {
    // Java
    val logback              = "ch.qos.logback"        % "logback-classic"         % V.logback
    val sl4j                 = "org.sl4j"              % "sl4j-api"                % V.slf4j from s"http://central.maven.org/maven2/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar" 
    val yodaTime             = "joda-time"             %  "joda-time"              % V.yodaTime
    val logging              = "com.typesafe.scala-logging"  %% "scala-logging"    % V.logging from s"http://central.maven.org/maven2/com/typesafe/scala-logging/scala-logging_2.12/3.7.2/scala-logging_2.12-3.7.2.jar"
    val config               = "com.typesafe"          %  "config"                 % V.config

    // Scala
    val json4sJackson        = "org.json4s"            %% "json4s-jackson"         % V.json4s
    val pureconfig           = "com.github.pureconfig" %% "pureconfig"             % V.pureconfig

    // Scala (test only)
    val specs2               = "org.specs2"            %% "specs2-core"            % V.specs2      % "test"
    val scalaTest            =  "org.scalatest"        %% "scalatest"              % V.scalaTest   % "test"
   
  }
}


import sbt._

object Dependencies {
  

  object V {
    // Java
   
    val yodaTime             = "2.9.9"
    val slf4j                = "1.7.5"
    val config               = "1.3.1"
    // Scala
  
    val scalaz7              = "7.0.9"
    val json4s               = "3.2.11"
    val pureconfig           = "0.8.0"
    // Scala (test only)
    val specs2               = "3.9.4"
  }

  object Libraries {
    // Java
    val yodaTime             = "joda-time"             %  "joda-time"              % V.yodaTime
    val slf4j                = "org.slf4j"             %  "slf4j-simple"           % V.slf4j
    val log4jOverSlf4j       = "org.slf4j"             %  "log4j-over-slf4j"       % V.slf4j
    val config               = "com.typesafe"          %  "config"                 % V.config

    // Scala
    val scalaz7              = "org.scalaz"            %% "scalaz-core"            % V.scalaz7
    val json4sJackson        = "org.json4s"            %% "json4s-jackson"         % V.json4s
    val pureconfig           = "com.github.pureconfig" %% "pureconfig"             % V.pureconfig

    // Scala (test only)
    val specs2               = "org.specs2"            %% "specs2-core"            % V.specs2   % "test"
   
  }
}

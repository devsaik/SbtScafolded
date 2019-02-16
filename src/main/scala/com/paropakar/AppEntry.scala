package com.paropakar
import com.typesafe.scalalogging.LazyLogging

object AppEntry extends App with LazyLogging   {


  val orchestrateInstance = new Orchestrator
  orchestrateInstance.orchestrate.map((statement:String) => logger.info(statement) )
}

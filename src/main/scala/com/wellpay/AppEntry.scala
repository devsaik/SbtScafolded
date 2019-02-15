package com.wellpay
import com.typesafe.scalalogging.LazyLogging

object AppEntry extends App with LazyLogging   {


  val classOrchestrateInstance = new ClassOrchestrator
  classOrchestrateInstance.orchestrate.map((statement:String) => logger.info(statement) )
}

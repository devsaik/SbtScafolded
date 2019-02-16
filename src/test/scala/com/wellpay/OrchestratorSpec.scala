package com.wellpay
import org.scalatest._

class OrchestratorSpec extends FlatSpec {

val orchestrator = new Orchestrator
  "orchestrate method" should "return a string" in {
    orchestrator.orchestrate() match {
      case Some(x:String) => assert(x.length > 0)
      case _ => assert(false)
    }
  }

}

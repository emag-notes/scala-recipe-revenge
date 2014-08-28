package chapter09.thread

import java.util.concurrent.TimeUnit

import akka.AkkaException
import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume}
import akka.actor._

/**
 * @author tanabe
 */
object SupervisorSample extends App {
  val system = ActorSystem()
  val ref = system.actorOf(Props[SupervisorActor], name = "mainActor")

  ref ! "Resume"
  ref ! "Restart"
  ref ! "else"

  TimeUnit.SECONDS.sleep(3)

  system.shutdown()
}

class SupervisorActor extends Actor {
  import context._

  override val supervisorStrategy = {
    OneForOneStrategy(maxNrOfRetries = 10) {
      case _: ArithmeticException => Resume
      case _: ActorKilledException => Restart
      case _: Exception => Escalate
    }
  }

  val subref = actorOf(Props[FailureActor], name = "subActor")

  override def receive: Receive = {
    case s: String => subref ! s
  }
}

class FailureActor extends Actor {

  override def postRestart(reason: Throwable) = {
    println("-- FailureActor を再起動しました(理由: %s)--".format(reason.getMessage))
  }

  override def receive: Receive = {
    case "Resume" => throw new ArithmeticException()
    case "Restart" => throw new AkkaException("Killed !!")
    case _ => throw new Exception
  }

}

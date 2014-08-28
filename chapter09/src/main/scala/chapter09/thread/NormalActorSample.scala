package chapter09.thread

import java.util.concurrent.TimeUnit

import akka.actor._

/**
 * @author tanabe
 */
class MainActor extends Actor with ActorLogging {
  import context._

  val subref = actorOf(Props[SubActor], name = "subActor")

  watch(subref)

  override def receive: Receive = {
    case s: String => subref ! s
    case Terminated(`subref`) => println("SubActor 終了")
    case _ => log.warning("unknown")
  }
}

class SubActor extends Actor {
  import context._

  override def receive: Actor.Receive = {
    case s: String => {
      println("メッセージを受信: %s".format(s))
      stop(self)
    }
  }
}

object NormalActorSample extends App {

  val system = ActorSystem()

  val ref = system.actorOf(Props[MainActor], name = "mainActor")

  ref ! "send message"

  TimeUnit.SECONDS.sleep(3)

  system.shutdown()

}

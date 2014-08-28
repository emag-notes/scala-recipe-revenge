package chapter09.thread

import java.util.concurrent.TimeUnit

import akka.actor.Actor.Receive
import akka.util.Timeout
import akka.actor._
import akka.actors_

/**
 * @author tanabe
 */
object FutureSample extends App {

  implicit val timeout = Timeout(5, TimeUnit.SECONDS)

  val system = ActorSystem()
  val ref = system.actorOf(Props[ReplyActor], name = "mainActor")

  val future = ref ? "World"

  future onComplete {
    case Right(result) => println(result)
    case Left(failure) => println("処理が失敗しました: %s".format(failure))
  }

}

class ReplyActor extends Actor {
  override def receive: Receive = {
    case s: String => sender ! "Hello " + s
    case _ => throw new IllegalArgumentException
  }
}

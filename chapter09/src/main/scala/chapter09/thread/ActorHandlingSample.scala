package chapter09.thread

import akka.actor.{Actor, ActorSystem, Props}

/**
 * @author tanabe
 */
class HandlingActor extends Actor {

  override def receive: Receive = {
    case s: String => println("Hello " + s)
    case _ => throw new IllegalArgumentException
  }

  override def preStart() = println("preStart")

  override def postStop() = println("postStop")

}

object ActorHandlingSample extends App {

  val system = ActorSystem()
  var ref = system.actorOf(Props[HandlingActor], name = "mainActor")

  ref ! "World"

  system.shutdown()
}

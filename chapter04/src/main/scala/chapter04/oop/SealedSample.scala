package chapter04.oop

/**
 * @author tanabe
 */
sealed abstract class Message

case class TextMessage() extends Message
case class ObjectMessage() extends Message
case class ByteMessage() extends Message

object SealedSample extends App {
  def message(m: Message) = m match {
    case TextMessage() => println("TextMessage")
    case ObjectMessage() => println("ObjectMessage")
    case ByteMessage() => println("ByteMessage")
  }

  message(ObjectMessage())
}
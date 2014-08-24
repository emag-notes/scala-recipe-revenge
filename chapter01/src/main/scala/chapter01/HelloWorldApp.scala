package chapter01

/**
 * @author tanabe
 */
object HelloWorldApp extends App {
  val name: String = args(0)
  println("Hello %s!".format(name))
}

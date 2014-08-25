package chapter04.oop

/**
 * @author tanabe
 */
abstract class AbstractClass {
  val value: String
  def hello(arg: String): String
}

class ConcreteClass extends AbstractClass {
  val value = "hello"
  def hello(arg: String) = "hello: " + arg
}

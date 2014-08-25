package chapter04.oop

/**
 * @author tanabe
 */
class HelloWorld(x: Int, y: Int) {
  println(x + y)

  def this(z: Int) = {
    this(z, 0)
  }

//  def greet(arg: String): String = "Hello World " + arg
  def greet(arg: String) = "Hello World " + arg
  def printHello() = println("Hello World")
  def hello = "Hello World"
}

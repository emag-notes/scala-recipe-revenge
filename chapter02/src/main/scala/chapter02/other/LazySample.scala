package chapter02.other

/**
 * @author tanabe
 */
object LazySample extends App {

  var i = 1

  val x = i * 2
  lazy val y = i + 2

  i = 2

  println(x)
  println(y)

  i = 3

  println(x)
  println(y)

}

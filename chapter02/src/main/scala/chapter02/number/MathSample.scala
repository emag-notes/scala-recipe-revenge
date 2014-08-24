package chapter02.number

/**
 * @author tanabe
 */
object MathSample extends App {

  import math._

  val d = 1.5

  println(round(d))
  println(floor(d))
  println(ceil(d))

  println(random)

  def randomInt(n: Double): Int = floor(random * n).toInt
  println(randomInt(10))

}

package chapter03.function

/**
 * @author tanabe
 */
object ClosureSample extends App {
  def multi(times: Int) = (i: Int) => i * times

  val tentimes = multi(10)
  println(tentimes(3))

  println(multi(100)(3))
}

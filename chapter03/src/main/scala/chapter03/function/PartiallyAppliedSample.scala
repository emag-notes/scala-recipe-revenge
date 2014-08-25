package chapter03.function

/**
 * @author tanabe
 */
object PartiallyAppliedSample extends App {

  println("-- 部分適用 --")
  def price(total: Int, discount: Int) = total - discount

  val f1 = price(1000, _: Int)
  val f2 = price _

  println(f1(500))
  println(f2(1000, 500))

  println("-- 部分関数を定義 --")
  val base: PartialFunction[Throwable, String] = {
    case _: IllegalArgumentException => "Parameter is invalid."
    case _: IllegalStateException => "State is invalid."
  }
  val ex: PartialFunction[Throwable, String] = {
    case _ => "No support."
  }

  def check(i: Int) = {
    try {
      if (i < 0) throw new IllegalArgumentException
      else i / 0
      "success"
    } catch base orElse ex
  }

  println(check(-2))
  println(check(2))
}

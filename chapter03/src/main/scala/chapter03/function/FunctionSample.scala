package chapter03.function

/**
 * @author tanabe
 */
object FunctionSample extends App {

  println("-- 関数の定義 --")
  val f1 = (i: Int) => i * 2
  val f2: Int => Int = (i) => i * 2
  val f3: Int => Int = i => i * 2
  val f4: Int => Int = _ * 2
  val f5 = (_: Int) + (_: Int)
  val f6 = () => println("Hello World")
  val f7 = ((_: Int) * 2).andThen(println)

  println(f1(10))
  println(f2(20))
  println(f3(30))
  println(f4(40))
  println(f5(50, 50))
  f6()
  f7(10)

  println("-- メソッドの引数に関数型を定義 --")
  def execute1(f: (Int) => Boolean) = f(10)
  def execute2(f: Int => Boolean) = f(20)
  def execute3(f: () => Unit) = f()

  println(execute1(i => i % 2 == 0))
  println(execute2(_ % 2 == 0))
  execute3(() => println("Hello World"))

  println("-- 戻り値を関数型にする --")
  def double1: Int => Int = {
    (i: Int) => i * 2
  }
  def double2 = (i: Int) => i * 2
  def double3: Int => Int = _ * 2

  println(double1(10))
  println(double2(20))
  println(double3(30))

  println("-- ネストした関数の定義 --")
  def list(capital: String) = {
    def isTokyo(address: String) = address contains capital

    println(isTokyo("Shibuya, Shibuya-ku, Tokyo"))
    println(isTokyo("Kanagawa, Kanagawa-ku, Yokohama, Kanagawa"))
  }

  list("Tokyo")

  println("-- メソッドを関数に変換する --")
  def price(total: Int) = "金額: " + total

  def printPrice(f: Int => String) = println(f(1000))
  printPrice(price)

}

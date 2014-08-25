package chapter04.oop

/**
 * @author tanabe
 */
object MethodSample extends App {

  println("-- インスタンスを生成してメソッドを呼び出す --")
  val instance = new HelloWorld(1, 2)

  println(instance.greet("name"))
  instance.printHello()
  println(instance.hello)

  println("-- 可変長引数のメソッド --")
  def args(values: String*) = for (s <- values) println(s)

  args()
  args("a")
  args("a", "b")
  args(List("a", "b"): _*)

  println("-- 引数名を指定してメソッドを呼び出す --")
  def tax(total: Int, rate: BigDecimal, discount: Int) = (total - discount) * rate

  println(tax(rate = BigDecimal(1.08), discount = 500, total = 10000))
  println(tax(10000, discount = 500, rate = BigDecimal(1.08)))

  println("-- 引数にデフォルト値を設定 --")
  def flat(total: Int = 10000, discount: Int = 500) = total - discount
  println(flat(discount = 1000))
  println(flat(5000))
  println(flat())

  import java.util.Calendar
  def priceDay(total: Int = 10000,
               discount: Int = if(Calendar.getInstance.get(Calendar.DATE) % 2 == 0) 500
                               else 100)
              = total - discount
  println(priceDay(discount = 1000))
  println(priceDay(5000))
  println(priceDay())

  println("-- 引数を遅延評価にする --")
  def lazyParam(execute: Boolean, f: => Unit) = {
    if (execute) f
  }

  lazyParam(execute = true, println("Hello"))
  lazyParam(execute = false, println("Hello"))
}

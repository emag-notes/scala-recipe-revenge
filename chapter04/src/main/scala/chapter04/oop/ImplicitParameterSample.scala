package chapter04.oop

/**
 * @author tanabe
 */
class TaxApply {

  def tax(implicit tax: Tax) = tax.rate * 0.01

  def calc(total: Int)(implicit vat: VAT, gst: GST) = {
    println("VAT: " + total * (vat.rate * 0.01))
    println("GST: " + total * (gst.rate * 0.01))
  }
}

object ImplicitValue {
  implicit val vat = new VAT(5)
  implicit val gst = new GST(10)

  implicit object Customs extends Tax {
    def rate: Int = 5
  }

  implicit def anyFormatter[A] = new Formatter[A] {
    def format(value: A): String = value.toString
  }
  implicit def dateFormatter[A <: java.util.Date] = new Formatter[A] {
    def format(value: A): String =
      new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(value)
  }

}

class VAT(val rate: Int)
class GST(val rate: Int)
trait Tax {
  def rate: Int
}
trait Formatter[A] {
  def format(value: A): String
}

object ImplicitParameterSample extends App {
  import ImplicitValue._

  val tax = new TaxApply
  tax.calc(1000)
  println(tax.tax)

  def println[A](value: A)(implicit f: Formatter[A]): Unit = Predef.println(f.format(value))
  println("Hello World!")
  println(9999)
  println(new java.util.Date)
  println(new java.sql.Date(new java.util.Date().getTime))

}
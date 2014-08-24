package chapter02.other

import java.util.{Calendar, Date}

/**
 * @author tanabe
 */
object ImplicitConversionSample extends App {

  implicit def date2calendar(date: Date): Calendar = {
    val cal = Calendar.getInstance()
    cal.setTime(date)
    cal
  }

  val date: Date = new Date()
  val cal: Calendar = date
  val year = date.get(Calendar.YEAR)
  println(year)

  def getDate(cal: Calendar): (Int, Int, Int) = {
    (cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH))
  }
  val (y, m, d) = getDate(date)
  println("%04d/%02d/%02d".format(y, m, d))


  object ListTailfill {
    implicit def listTailFill[A](list: List[A]) = new {
      def tailfill(min: Int) {
        if (min <= list.size) list.tail
        else list.tail ::: List.fill(min - list.size)(null)
      }
    }
  }

  import ListTailfill._

  val list = List("a", "b", "c")

  list.tailfill(2)  // => List("b", "c")
  list.tailfill(3)  // => List("b", "c", null)

}

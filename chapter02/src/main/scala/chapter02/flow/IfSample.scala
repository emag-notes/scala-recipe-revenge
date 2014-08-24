package chapter02.flow

/**
 * @author tanabe
 */
object IfSample extends App {

  val str = "Scala,Java"

  val list: List[String] = if (str != null) {
    str.split(",").toList
  } else {
    Nil
  }
  list.foreach(println)

  val result1 = if (str != null) {
    str.split(",").toList
  }
  println(result1)

  val result2 = if (str == null) {
    println("null")
  } else if (str == "") {
    println("空文字列")
  } else {
    str.split(",").toList
  }
  println(result2)

  val result3 = if (str == null) "" else str
  println(result3)

}

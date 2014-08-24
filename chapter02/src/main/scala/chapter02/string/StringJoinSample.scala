package chapter02.string

/**
 * @author tanabe
 */
object StringJoinSample extends App {

  val str: String = "Hello" + " " + "World!"
  println(str)

  val sb: StringBuilder = new StringBuilder()
  for (i: Int <- 0 to 10) {
    sb.append("i=%d\n".format(i))
  }
  println(sb)

}

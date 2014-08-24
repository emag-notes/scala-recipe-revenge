package chapter02.string

/**
 * @author tanabe
 */
object StringMatchSample extends App {

  // prefecture code
  val pattern = """^\d{3}-\d{4}+$"""

  val result1: Boolean = "244-0801".matches(pattern)
  println(result1)

  val result2: Boolean = "2440801".matches(pattern)
  println(result2)

}

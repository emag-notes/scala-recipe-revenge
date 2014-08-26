package chapter05.collection

/**
 * @author tanabe
 */
object ArraySample extends App {

  val array1 = Array("A", "B")
  println(array1)

  val name1 = array1(0)
  val name2 = array1(1)
  println(name1)
  println(name2)

  for(e <- array1) println(e)

  val array2 = new Array[String](2)
  array2(0) = "A"
  array2(1) = "B"

  for(e <- array2) println(e)

  val array3 = Array(Array("A", "B"), Array("C", "D"))

  for(x <- array3; y <- x) println(y)
}

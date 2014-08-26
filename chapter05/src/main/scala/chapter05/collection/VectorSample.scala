package chapter05.collection

/**
 * @author tanabe
 */
object VectorSample extends App {

  val vector = Vector("A", "B", "C")

  val e1 = vector(0)
  val e2 = vector(1)
  val e3 = vector(2)

  println(e1)
  println(e2)
  println(e3)

  vector.foreach(println)

  val newVector = vector.updated(1, "*")
  println(newVector)

}

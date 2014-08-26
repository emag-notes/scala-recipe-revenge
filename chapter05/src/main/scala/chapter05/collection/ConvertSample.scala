package chapter05.collection

/**
 * @author tanabe
 */
object ConvertSample extends App {

  {
    val list = List("A", "B", "C")
    val array = list.toArray

    println(array)
  }

  {
    val map = Map(1 -> "A", 2 -> "B")
    val list = map.toList

    println(list)
  }

  {
    val list = List((1, "A"), (2, "B"))
    val map = list.toMap

    println(map)
  }
}

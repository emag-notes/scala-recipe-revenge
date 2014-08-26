package chapter05.collection

import scala.collection.immutable.{TreeMap, HashMap}

/**
 * @author tanabe
 */
object CompareSample extends App {

  val list1 = List("A", "B")
  val list2 = List("A", "B")
  val list3 = List("A", "C")

  val result1 = list1 == list2
  val result2 = list1 == list3

  println(result1)
  println(result2)

  val result3 = List("A", "B") == Set("A", "B")
  println(result3)

  val result4 =
    HashMap("key1" -> "value1", "key2" -> "value2") ==
    TreeMap("key1" -> "value1", "key2" -> "value2")

  println(result4)

}

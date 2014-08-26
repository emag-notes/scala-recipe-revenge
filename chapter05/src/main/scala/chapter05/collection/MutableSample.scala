package chapter05.collection

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
 * @author tanabe
 */
object MutableSample extends App {

  println("-- ListBuffer --")

  val list = ListBuffer("A", "B")
  "Z" +=: list
  list += "C"
  List("X", "Y") ++=: list
  list ++= List("D", "E")
  list(4) = "BB"
  list -= "A"
  list --= List("C", "D")
  list.remove(1)

  val immutableList = list.toList

  println(list)
  println(immutableList)

  list.clear()
  println(list)

  println("-- ArrayBuffer --")

  val arrayBuffer = ArrayBuffer("A", "B")
  "Z" +=: arrayBuffer
  arrayBuffer += "C"
  List("X", "Y") ++=: arrayBuffer
  arrayBuffer ++= List("D", "E")
  arrayBuffer(4) = "BB"
  arrayBuffer -= "A"
  arrayBuffer.remove(2)

  println(arrayBuffer)

  println("-- mutable.Set --")

  import scala.collection.mutable.{Set => MutableSet}
  val set = MutableSet("A", "B")
  set += "C"
  set.add("D")
  set ++= Set("E", "F")
  set -= "A"
  set.remove("B")
  set --= Set("C", "D")

  println(set)

  set.clear()
  println(set)

  println("-- mutable.Map --")

  import scala.collection.mutable.{Map => MutableMap}

  val map = MutableMap("key1" -> "value1")
  map.put("key2", "value2")
  map += ("key3" -> "value3", "key4" -> "value4")
  map.remove("key1")
  map -= "key2"
  map --= List("key3", "key4")

  val immutableMap = map.toMap

  println(map)
  println(immutableMap)

}

package chapter10.javalink

import scala.collection.JavaConversions._

/**
 * @author tanabe
 */
object CollectionConversion extends App {

  def getList = {
    val list = new java.util.ArrayList[String]
    list.add("Scala")
    list.add("Java")
    list
  }

  getList.foreach(e => println(e))

}

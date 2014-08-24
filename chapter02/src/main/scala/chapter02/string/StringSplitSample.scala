package chapter02.string

import scala.util.matching.Regex

/**
 * @author tanabe
 */
object StringSplitSample extends App {

  {
    val source: String = "a,b,c"
    val result: Array[String] = source.split(",")

    result.foreach(println)
  }

  {
    val source: String = "a,b\tc"
    val regex: Regex = "[,\t]".r
    val result: Array[String] = regex.split(source)

    result.foreach(println)
  }

}

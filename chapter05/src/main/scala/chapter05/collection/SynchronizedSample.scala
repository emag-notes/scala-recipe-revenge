package chapter05.collection

import scala.collection.mutable._

/**
 * @author tanabe
 */
object SynchronizedSample extends App {

  val arrayBuffer = new ArrayBuffer[String] with SynchronizedBuffer[String]

  val set = new HashSet[String] with SynchronizedSet[String]

  val map = new HashMap[String, String] with SynchronizedMap[String, String]

}

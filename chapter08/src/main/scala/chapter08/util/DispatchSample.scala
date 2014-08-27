package chapter08.util

import dispatch._
import dispatch.Defaults._

/**
 * @author tanabe
 */
object DispatchSample extends App {

  val svc = url("http://api.hostip.info/country.php")
  val country = Http(svc OK as.String)
  val length = for (c <- country) yield c.length


}

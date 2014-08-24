package chapter01

import java.io.InputStream
import java.net.URL

import org.apache.commons.io.IOUtils

/**
 * @author tanabe
 */
object CommonsIOSample extends App {
  val in: InputStream = new URL("http://www.google.co.jp").openStream()
  try {
    println(IOUtils.toString(in))
  }finally {
    IOUtils.closeQuietly(in)
  }
}

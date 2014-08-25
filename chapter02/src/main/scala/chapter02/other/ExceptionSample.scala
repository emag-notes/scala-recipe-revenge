package chapter02.other

import java.io.{IOException, FileInputStream, InputStream}
import java.nio.charset.StandardCharsets

/**
 * @author tanabe
 */
object ExceptionSample extends App {

  println("-- try 式は値を返すことができる --")
  val in: InputStream = new FileInputStream("build.sbt")
  val content: String = try {
    val buf: Array[Byte] = new Array[Byte](in.available())
    in.read(buf)
    new String(buf, StandardCharsets.UTF_8)
  } catch {
    case e: IOException => e.toString
    case e: Exception => e.toString
  } finally {
    in.close()
  }
  println(content)

  println("-- Either を利用した例外処理の例 --")
  def readFile(fileName: String): Either[Throwable, String] = {
    val in: InputStream = new FileInputStream(fileName)
    try {
      val buf: Array[Byte] = new Array[Byte](in.available())
      in.read(buf)
      Right(new String(buf, StandardCharsets.UTF_8))
    } catch {
      case e => Left(e)
    } finally {
      in.close()
    }
  }

  val result: Either[Throwable, String] = readFile("build.sbt")
  result match {
    case Left(e) => e.printStackTrace()
    case Right(s) => println(s)
  }
}

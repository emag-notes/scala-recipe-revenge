package chapter06.io

/**
 * @author tanabe
 */
object JavaInterOpSample extends App {

  import scalax.io.Resource
  import scalax.io.Codec
  import java.nio.charset.StandardCharsets

  implicit val codec = Codec.UTF8

  def java2scala() = {
    val in = new java.io.FileInputStream("build.sbt")
    val inputResource = Resource.fromInputStream(in)

    println(inputResource.string)

    val out = new java.io.ByteArrayOutputStream()
    val outputResource = Resource.fromOutputStream(out)

    outputResource.write("こんにちは, Scala IO!")
    println(new String(out.toByteArray), StandardCharsets.UTF_8)
  }
  java2scala()

  def scala2java() = {
    val resource = Resource.fromFile("build.sbt")

    val in: java.io.InputStream = resource.inputStream.open().get
    in.close()

    val out: java.io.OutputStream = resource.outputStream.open().get
    out.close()

    val result: Either[List[Throwable], String] =
      resource.inputStream.acquireFor { in: java.io.InputStream =>
        val bytes = new Array[Byte](resource.size.get.toInt)
        in.read(bytes)
        new String(bytes, StandardCharsets.UTF_8)
      }

    result match {
      case Left(x) => x.foreach { e => println(e.getMessage) }
      case Right(x) => println(x)
    }
  }
  scala2java()

  def managedResourceSample() = {
    val resource = Resource.fromInputStream(new java.io.FileInputStream("build.sbt"))

    val result: Either[List[Throwable], String] =
      resource.inputStream.acquireFor { in =>
        val bytes = new Array[Byte](resource.size.get.toInt)
        in.read(bytes)
        new String(bytes, StandardCharsets.UTF_8)
      }

    result match {
      case Left(x) => x.foreach { e => println(e.getMessage) }
      case Right(x) => println(x)
    }
  }
  managedResourceSample()
}

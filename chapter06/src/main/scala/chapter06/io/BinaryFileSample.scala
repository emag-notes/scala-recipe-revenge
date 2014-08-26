package chapter06.io

import java.nio.charset.StandardCharsets

/**
 * @author tanabe
 */
object BinaryFileSample extends App {

  {
    import scalax.file.Path

    val path = Path("LICENSE")
    val bytes: Array[Byte] = path.byteArray

    println(new String(bytes, StandardCharsets.UTF_8))

    val out = new java.io.ByteArrayOutputStream()
    path.bytes.foreach (out.write(_))
    println(new String(out.toByteArray, StandardCharsets.UTF_8))
  }

  {
    import scalax.file.Path

    val path = Path("hoge.txt")
    val bytes = "Hello, Scala IO!".getBytes

    path.write(bytes)
    path.append(bytes)
  }

  {
    import scalax.file.Path

    for {
      processor <- Path("output.txt").outputProcessor
      out = processor.asOutput
    } {
      out.write("Hello\n")
      out.write("World\n")
    }
  }

}

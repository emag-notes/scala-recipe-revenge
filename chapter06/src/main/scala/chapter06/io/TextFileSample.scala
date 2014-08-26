package chapter06.io

/**
 * @author tanabe
 */
object TextFileSample extends App {

  {
    import scalax.file.Path

    val path = Path(".gitignore")
    val str = path.string
    println(str)

    path.lines().foreach (println)
  }

  {
    import scalax.file.Path

    val path = Path("hoge.txt")

    path.write("ファイルに文字列を出力")
    path.append("ファイルに文字列を追加")
  }

  {
    import scalax.io.Resource

    val resource = Resource.fromFile("hoge.txt")

    resource.write("Hello, Scala IO!")
    println(resource.string)
  }

  {
    import scalax.file.Path
    import scalax.io.Codec

    import java.nio.charset.StandardCharsets

    implicit val codec = Codec(StandardCharsets.UTF_8)

    val path = Path("hoge.txt")
    val str1 = path.string
    println(str1)

    val str2 = path.string(Codec(StandardCharsets.UTF_8))
    println(str2)
  }
}

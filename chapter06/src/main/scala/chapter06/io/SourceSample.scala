package chapter06.io

import java.nio.charset.StandardCharsets

import scala.io.Source

/**
 * @author tanabe
 */
object SourceSample extends App {

  {
    println("-- ファイルの内容を読み込み --")

    val source = Source.fromFile("build.sbt", StandardCharsets.UTF_8.name())

    try {
      source.getLines().foreach { line: String =>
        println(line)
      }
    } finally {
      source.close()
    }
  }

  {
    println("-- 空行を除去 --")

    val source1 = Source.fromFile("build.sbt", StandardCharsets.UTF_8.name())
    source1.getLines().filter(_ != "") foreach { line =>
      println(line)
    }
    source1.close()

    println("-- 行番号付きで表示 --")
    val source2 = Source.fromFile("build.sbt", StandardCharsets.UTF_8.name())
    val linesWithIndex: Iterator[String] =
      source2.getLines().zipWithIndex.map { case(line, index) =>
        "%02d: %s".format(index + 1, line)
      }
    linesWithIndex.foreach { println }
    source2.close()
  }

  {
    println("-- 指定した URL から読み込み --")

    val source1 = Source.fromURL("http://emamotor.org/", StandardCharsets.UTF_8.name())
    println(source1.mkString)
    source1.close()

    println("-- InputStream から読み込み --")
    val source2 = Source.fromInputStream(getClass.getResourceAsStream("/config.properties"))
    println(source2.mkString)
    source2.close()

    println("-- バイト配列から読み込み --")
    val source3 = Source.fromBytes("Hello, Scala!".getBytes)
    println(source3.mkString)
    source3.close()
  }
}

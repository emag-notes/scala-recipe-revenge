package chapter02.string

import scala.util.matching.Regex
import scala.util.matching.Regex.Match

/**
 * @author tanabe
 */
object RegexSample extends App {

  {
    println("-- 正規表現にマッチした部分の取得 --")

    val regex: Regex = """\d{3}""".r
//    val regex: Regex = new Regex("""\d{3}""")

    val source: String = "123 to 456"

    regex.findAllIn(source).foreach(println)

    val list: List[String] = regex.findAllIn(source).toList;
    list.foreach(println)
  }

  {
    println("-- 正規表現のグループ化 --")

    val regex: Regex = """<a href="(.*?)">(.*?)</a>""".r

    var source =
      """
        |<a href="http://www.google.co.jp/">Google</a>
        |<a href="http://www.scala-lang.org/">Scala</a>
      """.stripMargin

    regex.findFirstMatchIn(source).foreach { m: Match =>
      println("matched: " + m.matched)
      println("group0: " + m.group(0))
      println("group1: " + m.group(1))
      println("group2: " + m.group(2))

      println("before0: " + m.before(0))
      println("after0: " + m.after(0))
      println("before1: " + m.before(1))
      println("after1: " + m.after(1))
      println("before2: " + m.before(2))
      println("after2: " + m.after(2))
    }

    regex.findAllIn(source).matchData.foreach { m: Match =>
      println("group0: " + m.group(0))
      println("group1: " + m.group(1))
      println("group2: " + m.group(2))
    }
  }

  {
    println("-- 正規表現のグループ化(名前付きグループ) --")

    val regex: Regex = new Regex("""<a href="(.*?)">(.*?)</a>""", "url", "label")

    val source =
      """
        |<a href="http://www.google.co.jp/">Google</a>
        |<a href="http://www.scala-lang.org/">Scala</a>
      """.stripMargin

    regex.findAllIn(source).matchData.foreach { m: Match =>
      println("url: " + m.group("url"))
      println("label: " + m.group("label"))
    }

  }

  {
    println("-- 正規表現による文字列の置換 --")

    val regex: Regex = """\d{3}""".r

    val source: String = "123 to 456"

    val result1: String = regex.replaceAllIn(source, {
      m: Match => "*" * m.group(0).length
    })

    println(result1)

    val result2: String = source.replaceAll("""\d{3}""", "***")
    println(result2)
  }

}

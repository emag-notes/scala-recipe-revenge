package chapter02.string

/**
 * @author tanabe
 */
object StringLinesSample extends App {

  val source: String = "1行目\n2行目\n3行目"

  source.lines.foreach(println)
  source.linesWithSeparators.foreach(print)

}

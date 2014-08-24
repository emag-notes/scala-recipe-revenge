package chapter02.flow

/**
 * @author tanabe
 */
object ForSample extends App {

  println("-- 指定した回数のループ処理 --")

  for (i <- 1 to 10) println(i)

  for (i <- 1 to (10, 2)) println(i)

  val range = Range(1, 10)
  for (i <- range) println(i)


  println("-- for ループでのフィルタリング --")

  val list: List[String] = List("Java", "Scala", "Clojure")
  for (lang: String <- list if ! lang.startsWith("J")) println(lang)


  println("-- 複数の条件を指定 --")

  for (lang: String <- list
        if ! lang.startsWith("J")
        if ! lang.startsWith("C")) {
    println(lang)
  }

  // or

  for (lang: String <- list
        if ! lang.startsWith("J") && ! lang.startsWith("C")) {
    println(lang)
  }


  println("-- for ループから新しいコレクションを作成する --")

  val result1: List[String] = for(lang: String <- list if ! lang.startsWith("J")) yield lang
  result1.foreach(println)
  
  
  println("-- 要素を加工したコレクションを作成 --")
  
  val result2: List[String] = for(lang: String <- list) yield lang.toUpperCase
  result2.foreach(println)


  println("-- for ループを入れ子にする --")

  for (x <- 1 to 10) {
    for (y <- 1 to 10) {
      println("x=%d, y=%d".format(x, y))
    }
  }

  // or

  for (x <- 1 to 10; y <- 1 to 10) println("x=%d, y=%d".format(x, y))

  // or

  for {x <- 1 to 10
       y <- 1 to 10} {
    println("x=%d, y=%d".format(x, y))
  }


  println("-- 入れ子のリスト --")

  val nestedList: List[List[String]] = List(
    List[String]("Java", "C#", "Scala"),
    List[String]("PHP", "Perl", "JavaScript")
  )

  for (row <- nestedList; item <- row if item.startsWith("Java")) println(item)

}

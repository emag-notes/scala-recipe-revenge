package chapter05.collection

/**
 * @author tanabe
 */
object TupleSample extends App {

  println("-- 要素を 2 つ持つタプル --")

  val user1 = (1, "Naoki Takezoe")
  val user2 = Tuple2(2, "Takako Shimamoto")

  println(user1)
  println(user2)

  println("-- 要素を 3 つ持つタプル --")

  val book1 = ("現場で使えるJavaライブラリ", "翔泳社", 3780)
  val book2 = Tuple3("Scala逆引きレシピ", "翔泳社", 3200)

  println(book1)
  println(book2)

  println("-- タプルから値を取得 --")

  val id = user1._1
  val name = user1._2

  println(id)
  println(name)

  println("-- タプルから値を分解 --")

  val (bookName, publisher, price) = book1
  println(bookName)
  println(publisher)
  println(price)

  println("-- パターンマッチで値を抽出 --")
  book2 match {
    case (bookName, publisher, price) => {
      println(bookName)
      println(publisher)
      println(price)
    }
  }
}

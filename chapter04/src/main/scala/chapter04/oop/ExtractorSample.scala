package chapter04.oop

/**
 * @author tanabe
 */
class Book private
  (val title: String, val author: String, val publisher: String, val price: Int)

object Book {
  def apply(title: String, author: String, publisher: String, price: Int): Book =
    new Book(title, author, publisher, price)

  def unapply(book: Book): Option[(String, String, String, Int)] =
    Some(book.title, book.author, book.publisher, book.price)
}

object ExtractorSample extends App {
  val book = Book("Seasar2徹底入門", "竹添直樹", "翔泳社", 3990)

  val Book(title, author, publisher, price) = book

  println("タイトル: " + title)
  println("著者: " + author)
  println("出版社: " + publisher)
  println("価格: " + price)
}
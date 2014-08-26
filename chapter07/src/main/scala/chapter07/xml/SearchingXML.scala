package chapter07.xml

/**
 * @author tanabe
 */
object SearchingXML extends App {

  val xml =
  <book>
    <title>Scala逆引きレシピ</title>
    <price>3200</price>
    <authors>
      <author id="1">竹添直樹</author>
      <author id="2">島本多可子</author>
    </authors>
  </book>

  println("-- \\メソッド(子要素のみ検索対象) --")

  val title = xml \ "title"
  val book = xml \ "book"
  val author = xml \ "author"

  println(title)
  println(book)
  println(author)

  println("-- \\\\メソッド(全要素が検索対象) --")

  val title2 = xml \\ "title"
  val book2 = xml \\ "book"
  val author2 = xml \\ "author"

  println(title2)
  println(book2)
  println(author2)

  println("-- 1番目の auhtor 要素を取得 --")

  val author1 = (xml \\ "author")(1)
  println(author1)

  println("""-- "Scala" を含む title 要素 """)

  val scala = (xml \ "title") { node =>
    node.text.contains("Scala")
  }
  println(scala)

  println("-- title 要素の値 --")

  val titleBody = (xml \ "title").text
  println(titleBody)

  println("-- 0 番目の author 要素から id 属性の値を取得 --")

  val attr1 = (xml \\ "author")(0).attribute("id")
  val attr2 = (xml \\ "author")(0) \ "@id"

  println(attr1)
  println(attr2)
}

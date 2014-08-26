package chapter07.xml

import java.nio.charset.StandardCharsets

import scala.xml.XML

/**
 * @author tanabe
 */
object SaveXML extends App {

  val xml =
  <book>
    <title>Scala逆引きレシピ</title>
    <price>3200</price>
  </book>

  XML.save(
    filename = "book.xml",
    node = xml,
    enc = StandardCharsets.UTF_8.name(),
    xmlDecl = true
  )

}

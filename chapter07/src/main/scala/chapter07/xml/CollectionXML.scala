package chapter07.xml

import scala.xml.Elem

/**
 * @author tanabe
 */
object CollectionXML extends App {

  val xml =
    <book>
      <title>Scala逆引きレシピ</title>
      <price>3200</price>
      <authors>
        <author>
          <id>1</id>
          <name>竹添直樹</name>
          <sex>M</sex>
        </author>
        <author>
          <id>2</id>
          <name>島本多可子</name>
          <sex>F</sex>
        </author>
      </authors>
    </book>

  val authors = (xml \\ "author").theSeq

  authors.foreach { author =>
    author.child.collect { case profile: Elem => profile
    } foreach println
  }

}

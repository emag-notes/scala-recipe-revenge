package chapter07.xml

import scala.xml.XML

/**
 * @author tanabe
 */
object LoadXML extends App {

  val strXml =
    """
      |<user>
      | <id>100</id>
      | <name>Yoshimasa Tanabe</name>
      |</user>
    """.stripMargin
  val elem1 = XML.loadString(strXml)
  println(elem1)
  
  val is = Thread.currentThread.getContextClassLoader.getResourceAsStream("user.xml")
  val elem2 = XML.load(is)
  println(elem2)

}

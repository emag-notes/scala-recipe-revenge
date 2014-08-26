package chapter07.xml

/**
 * @author tanabe
 */
object CompareXML extends App {

  val xml =
  <book>
    <title>Seasar2徹底入門</title>
    <author id="1">竹添直樹</author>
  </book>

  val other =
  <book>
    <title>Seasar2徹底入門</title>
  </book>

  println(xml.strict_==(other))
  println(xml.strict_!=(other))

  val same =
    <author id="1">竹添直樹</author>
  
  println(( xml \ "author" ).strict_==(same))
  println(( xml \ "author" ).strict_!=(same))
}

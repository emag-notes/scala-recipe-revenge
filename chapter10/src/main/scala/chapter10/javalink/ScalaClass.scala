package chapter10.javalink

/**
 * @author tanabe
 */
class ScalaClass {
  @throws(classOf[Exception])
  def output(): Unit = {
    throw new Exception("From ScalaClass")
  }
}

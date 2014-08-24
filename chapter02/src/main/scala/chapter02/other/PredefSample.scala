package chapter02.other

/**
 * @author tanabe
 */
object PredefSample extends App {

  val name: String = readLine("Input your name: ")
  printf("Hello %s!\n", name)

  val result: List[Any] = readf("{0},{1}")
  result.foreach { a: Any => println(a)}

  def printMessage(message: String): Unit = {
    assert(message != null, "引数 message は null であってはいけません")
    println(message)
  }
  printMessage("Hello")
  printMessage(null)

}

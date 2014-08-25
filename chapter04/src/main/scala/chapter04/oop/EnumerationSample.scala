package chapter04.oop

/**
 * @author tanabe
 */
object Sex extends Enumeration {
  type Sex = Value
  val Man, Woman = Value
}

object EnumerationSample extends App {
  import Sex._

  println(Man)
  println(Woman.id)
  val man = Sex.withName("Man")
  val woman = Sex(1)
  def printSex = Sex.values foreach println
  printSex
}

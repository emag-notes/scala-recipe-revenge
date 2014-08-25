package chapter04.oop

/**
 * @author tanabe
 */
class SuperClass {
  val id = 1
  var key = "key1"
  def name = "SuperClass"
}

class SubClass extends SuperClass {
  override val id = 100
  key = "key100"
  override def name = "SubClass: " + super.name
}

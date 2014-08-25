package chapter04.oop

/**
 * @author tanabe
 */
trait Language {
  case class Java(name: String)
  case class ObjectiveC(name: String)
}

trait OS { self: Language =>
  object Android {
    val devlang = List(Java)
  }
}

trait SmartPhone extends Language with OS {
  println(Android.devlang)
}

trait UserDAO {
  def byId(id: Long): String
}
trait DivisionDAO {
  def allData: List[String]
}

trait SampleLogic {
  self: UserDAO with DivisionDAO =>

  def show(id: Long) = {
    val user = byId(id)
    val all = allData

    println(user)
    println(all)
  }
}

trait UserDAOImpl extends UserDAO {
  def byId(id: Long) = "ID: %d".format(id)
}
trait DivisionDAOImpl extends DivisionDAO {
  def allData = List("Development", "Sales")
}

object SelfTypeSample extends App {
  val phone = new SmartPhone {}

  val logic = new SampleLogic with UserDAOImpl with DivisionDAOImpl
  logic.show(100)
}

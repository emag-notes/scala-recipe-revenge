package chapter04.oop

/**
 * @author tanabe
 */
trait Executor {
  val value: String
  lazy val defaultValue = "Prefix: " + value
  def handle()
}

class OutputConsole extends Executor {
  val value = "handle execute"
  def handle() = println(value)
}

trait DefaultExecutor extends Executor {
  abstract override def handle() = {
    println("start")
    super.handle()
    println("end")
  }
}

trait TraitPrint {
  def print() = println("TraitPrint")
}
class ClassPrint {
  def print() = println("ClassPrint")
}

object TraitSample extends App {
  val exe = new OutputConsole with DefaultExecutor
  exe.handle()

  val print = new ClassPrint with TraitPrint {
    override def print() = {
      super.print()
      super[TraitPrint].print()
      super[ClassPrint].print()
    }
  }
  print.print()

  val output = new OutputConsole
  println(output.defaultValue)
}
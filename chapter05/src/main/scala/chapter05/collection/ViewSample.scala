package chapter05.collection

/**
 * @author tanabe
 */
object ViewSample extends App {

  {
    val list = List(0, 1, 2, 3, 4, 5)

    val view = list.view(2, 5)

    println(view)
    println(view.mkString(","))
  }

  {
    val list = List(0, 1, 2, 3, 4, 5)

    val view = list.view.map { _ + 1 }.map { _ * 2 }

    println(view)
    println(view.mkString(","))

    val seq = view.force

    println(seq)
  }

  {
    import scala.collection.mutable._

    val list = ListBuffer(0, 1, 2, 3, 4, 5)

    val view = list.view

    println(view.mkString(","))

    list(0) = 99
    println(view.mkString(","))
  }


}

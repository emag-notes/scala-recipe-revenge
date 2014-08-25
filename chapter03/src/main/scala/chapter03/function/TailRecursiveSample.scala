package chapter03.function

import scala.annotation.tailrec
import scala.util.control.TailCalls._

/**
 * @author tanabe
 */
object TailRecursiveSample extends App {

  println("-- 末尾再帰でループ処理 --")
  @tailrec
  def sum(total: Int, list: List[Int]): Int = {
    if (list.isEmpty) total
    else sum(total + list.head, list.tail)
  }

  val res = sum(0, List(100, 50, 10))
  println(res)

  println("-- トランポリン --")
  def plus(total: Int, list: List[Int]): TailRec[Int] = {
    if (list.isEmpty) done(total)
    else tailcall(minus(total + list.head, list.tail))
  }
  def minus(total: Int, list: List[Int]): TailRec[Int] = {
    if (list.isEmpty) done(total)
    else tailcall(plus(total - list.head, list.tail))
  }

  val res2 = plus(0, List(100, 50, 10)).result
  println(res2)

}

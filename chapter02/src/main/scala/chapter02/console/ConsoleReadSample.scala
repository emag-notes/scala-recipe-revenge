package chapter02.console

import scala.io.StdIn

/**
 * @author tanabe
 */
object ConsoleReadSample extends App {
  val name = StdIn.readLine("Please input your name: ")
  println("Hello %s!".format(name))

  print("Please input your age: ")
  val age: Int =StdIn.readInt()
  println("You are %d years old.".format(age))

  print("Please input YYYY/MM/DD: ")
  val list: List[Any] = StdIn.readf("{0}/{1}/{2}")
  println("year : %s".format(list(0)))
  println("month: %s".format(list(1)))
  println("day  : %s".format(list(2)))

  print("Please input YYYY/MM/DD: ")
  val (year: String, month: String, day: String) = StdIn.readf3("{0}/{1}/{2}")
  println("year : %s".format(year))
  println("month: %s".format(month))
  println("day  : %s".format(day))
}

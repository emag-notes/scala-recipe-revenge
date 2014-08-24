package chapter02.flow

import scala.util.control.Breaks

/**
 * @author tanabe
 */
object BreaksSample extends App {

  val mybreaks = new Breaks()
  import mybreaks.{break, breakable}

  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i == 5) {
        break()
      }
    }
    println("no ops")
  }

  val mycontinue = new Breaks()
  import mycontinue.{break => continue, breakable => continuable}

  for (i <- 1 to 10) {
    continuable {
      if (i < 5) {
        continue()
      }
    }
    println(i)
  }
}

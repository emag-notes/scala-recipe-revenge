package chapter08.util

/**
 * @author tanabe
 */
object ProcessSample extends App {

  import scala.sys.process._

  val code = "ls -al" !

  println("終了コード: " + code)

  val result = "ls -al" !!

  println("実行結果: " + result)

  "mkdir test1" ### "cp *.jar test1" !

  "mkdir test2" #&& "cp *.jar test2" !

  "mkdir test3" #|| "cp *.jar test3" !

  "cat sample.sbt" #> new java.io.File("result.txt") !

  "echo Hello!" #>> new java.io.File("result.txt") !

  "grep name" #< new java.io.File("result.txt") !

  "ps" #| "grep java" !
}

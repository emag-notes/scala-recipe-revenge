package chapter04.oop

import java.io.{FileOutputStream, OutputStream}

/**
 * @author tanabe
 */
class Nonvariant[A] {
  private var a: A = _
  def head: A = a
  def put(arg: A) = a = arg
}

class Covariant[+A](a: A) {
  def head: A = a
}

class Contravariant[-A](a: A) {
  def put(arg: A) = {
    println(a)
    println(arg)
  }
}

class GeneralizedTypeConstraints[A](param: A) {
  def print(implicit evidence: A =:= String) = println(param)
  def output(implicit evidence: A <:< OutputStream) = println(param)
  def double(implicit evidence: A => Long) = param * 2
}

object GenericsSample extends App {
  val v1: Nonvariant[String] = new Nonvariant[String]
  v1.put("非変")
  println(v1.head)

  val v2: Covariant[AnyRef] = new Covariant[AnyRef](new Object)
  val v3: Covariant[AnyRef] = new Covariant[String]("共編")
  println(v2.head)
  println(v3.head)

  val v4: Contravariant[String] = new Contravariant[String]("反変")
  val v5: Contravariant[String] = new Contravariant[AnyRef](new Object)
  v4.put("Hello!")
  v5.put("Hello!")

  def store[A <: OutputStream](stream: A) = println("%s: 出力処理".format(stream))
  store[FileOutputStream](new FileOutputStream("ファイル名"))

  import scala.xml._
  def store2[A >: Node](node: A) = println("%s: 出力処理".format(node))
  store2[NodeSeq](<book>Scala逆引きレシピ</book>)

  def store3[A <% Long](num: A) = println("%s: 出力処理".format(num * 2))
  store3[Int](10)

  val gtc1 = new GeneralizedTypeConstraints[String]("Hello!")
  gtc1.print
  val gtc2 = new GeneralizedTypeConstraints[FileOutputStream](new FileOutputStream("ファイル名"))
  gtc2.output
  val gtc3 = new GeneralizedTypeConstraints[Int](10)
  println(gtc3.double)

  import scala.reflect.ClassTag
  def newarray[T: ClassTag](xs: T*): Array[T] = {
    val clazz = implicitly[ClassTag[T]].runtimeClass
    println(clazz)

    val array = new Array[T](xs.length)
    var i = 0
    for (x <- xs.iterator) {
      array(i) = x; i += 1
    }
    array
  }
  println(newarray(1, 2).toList)
  println(newarray("Hello!", "Hello2").toList)

}

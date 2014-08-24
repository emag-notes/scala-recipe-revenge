package chapter02.flow

/**
 * @author tanabe
 */
object PatternMatchSample extends App {

  println("-- 基本的なパターンマッチのサンプル --")

  def basicMatchSample(i: Int): Unit = {
    val Java : Int = 0
    val Scala: Int = 1

    val lang: String = i match {
      case Java => "Java"
      case Scala => "Scala"
      case _ => throw new IllegalArgumentException
    }

    println(lang)
  }

  basicMatchSample(0)
  basicMatchSample(1)

  println("-- 型によるパターンマッチのサンプル --")

  def getLength(value: AnyRef): Int = {
    value match {
      case x: String => x.length
      case x: Array[_] => x.length
      case x: Iterable[_] => x.size
      case _ => throw new IllegalArgumentException
    }
  }

  println(getLength("aaa"))
  println(getLength(List[String]("aaa", "bbb")))
  println(getLength(Array[String]("aaa", "bbb")))

  println("-- ケースクラスのパターンマッチのサンプル --")

  case class Employee(val empId: Int, val name: String)

  def caseClassMatchSample(emp: Employee) {
    emp match {
      case Employee(_, "Naoki") => {
        println("""name が "Naoki" の場合""")
      }
      case Employee(1, _) => {
        println("""empId が 1 の場合""")
      }
      case Employee(empId, name) => {
        println("すべての Employee にマッチ (empId=%s, name=%s".format(empId, name))
      }
    }
  }

  case class Publisher(val name: String, val address: String, val tel: String)
  case class Book(val title: String, val price: Int, val author: String, val publisher: Publisher)

  def nestedCaseClassMatchSample(book: Book) {
    book match {
      case Book(name, price, author, Publisher("翔泳社", _, _)) => {
        println(""" hogehoge """)
      }
      case _ => {}
    }
  }

  println("-- List に対するパターンマッチのサンプル --")

  def listMatchSample(list: List[Int]) {
    list match {
      case List(1, 2, 3) => {
        println("長さが 3 , 要素の値が 1, 2, 3 のリスト")
      }
      case List(_, _) => {
        println("長さ 2 のリスト")
      }
      case List(a, b, c) => {
        println("長さ 3 のリスト (%s, %s, %s)".format(a ,b ,c))
      }
      case List(1, _*) => {
        println("先頭の要素の値が 1 で長さは任意のリスト")
      }
      case _ => {
        println("どの条件にもマッチしない場合")
      }
    }
  }

  listMatchSample(List(1, 2, 3))
  listMatchSample(List(4, 5))
  listMatchSample(List(6, 7, 8))
  listMatchSample(List(1, 3, 5, 7))
  listMatchSample(List(2))

  println("-- 配列に対するパターンマッチのサンプル --")

  def arrayMatchSample(array: Array[Int]) {
    array match {
      case Array(1, 2, 3) => {
        println("長さが 3 , 要素の値が 1, 2, 3 の配列")
      }
      case Array(_, _) => {
        println("長さ 2 の配列")
      }
      case Array(a, b, c) => {
        println("長さ 3 の配列 (%s, %s, %s)".format(a ,b ,c))
      }
      case Array(1, _*) => {
        println("先頭の要素の値が 1 で長さは任意の配列")
      }
      case _ => {
        println("どの条件にもマッチしない場合")
      }
    }
  }

  arrayMatchSample(Array(1, 2, 3))
  arrayMatchSample(Array(4, 5))
  arrayMatchSample(Array(6, 7, 8))
  arrayMatchSample(Array(1, 3, 5, 7))
  arrayMatchSample(Array(2))

  println("-- List を再帰的に処理するサンプル --")

  def printElements(list: List[Int]) {
    list match {
      case x :: xs => {
        println(x)
        printElements(xs)
      }
      case Nil => println("end")
    }
  }

  printElements(List[Int](1, 2, 3, 4))
  printElements(List[Int]())

  println("-- タブルに対するパターンマッチのサンプル --")

  def tupleMatchSample(tuple: (Int, Int)) {
    tuple match {
      case (1, 2) => {
        println("値が 1, 2 だった場合")
      }
      case (1, _) => {
        println("1 つめの値が 1 だった場合")
      }
      case (a, b) => {}
        println("上記の条件にマッチしない場合 (%s, %s)".format(a, b))
    }
  }

  tupleMatchSample((1, 1))
  tupleMatchSample((1, 2))
  tupleMatchSample((2, 3))

  println("-- 正規表現によるパターンマッチのサンプル --")

  def regexMatchSample(s: String) {
    val pattern = """(\d{3})-(\d{4})""".r
    s match {
      case pattern("111", "2222") => println("111-2222の場合")
      case pattern(a, b) => println("パターンにマッチしました (%s-%s)".format(a, b))
      case _ => println("マッチしませんでした")
    }
  }

  regexMatchSample("111-2222")
  regexMatchSample("333-4444")
  regexMatchSample("111-222")

  println("-- XMLに対するパターンマッチのサンプル --")

//  import scala.xml.Elem
//  def xmlMatchSample(e: Elem) {
//    e match {
//      case <book>{child}</book> => {
//        println(child.text)
//      }
//    }
//  }


}

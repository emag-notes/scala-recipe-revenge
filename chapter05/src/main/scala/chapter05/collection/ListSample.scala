package chapter05.collection

/**
 * @author tanabe
 */
object ListSample extends App {

  def create() = {
    println("-- List の生成 --")

    val list1 = List("A", "B")
    println(list1)

    val size = list1.length
    val isEmpty = list1.isEmpty
    val nonEmpty = list1.nonEmpty

    val name1 = list1(0)
    val name2 = list1(1)

    println("size=%d".format(size))
    println("isEmpty=%s".format(isEmpty))
    println("nonEmpty=%s".format(nonEmpty))
    println("name1=%s".format(name1))
    println("name2=%s".format(name2))

    val list2 = "A" :: "B" :: Nil
    println(list2)

    val list3 = ("A" :: "B" :: Nil) :: ("C" :: "D" :: Nil) :: Nil
    println(list3)

    val list4 = List("A", "B") ::: List("C", "D")
    println(list4)
  }
  create()

  def get() = {
    println("-- 要素の取得 --")

    val list: List[String] = List("A", "B", "C", "D")

    val head = list.head
    println(head)

    val tail = list.tail
    println(tail)

    val second = list.tail.head
    println(second)

    val third = list.tail.tail.head
    println(third)

    val last1 = list.last
    val last2 = list.reverse.head
    println(last1)
    println(last2)
  }
  get()

  def add() = {
    println("-- 要素の追加 --")

    val list = List("A", "B")

    val newList1 = list :+ "C"
    println(newList1)

    val newList2 = "C" +: list
    println(newList2)

    val newList3 = list ::: "C" :: Nil
    println(newList3)

    val newList4 = "C" :: list
    println(newList4)
  }
  add()

  def remove() = {
    println("-- 要素の削除 --")

    {
      val list = List("A", "B", "C")

      val result1 = list.filter { _ != "C" }
      val result2 = list.filterNot { _ == "C" }

      println(result1)
      println(result2)
    }

    {
      val list = List("A", "B", "C")

      val target = List("A", "B")
      val result1 = list.filter { ! target.contains(_) }
      val result2 = list.filterNot { target.contains(_) }
      println(result1)
      println(result2)
    }

    {
      val list = List("A", "B", "C")

      val result1 = list.filter { _ != "C" } map { _.toLowerCase }
      val result2 = list.withFilter { _ != "C" } map { _.toLowerCase }

      println(result1)
      println(result2)
    }
  }
  remove()

  def concat() = {
    println("-- List の連結 --")

    val list1 = List("A", "B")
    val list2 = List("C", "D")
    val array = Array("E", "F")

    val newList1 = list1 ++ list2
    val newList2 = list1 ++ array

    println(newList1)
    println(newList2)

    val newArray1 = array ++ list1
    val newArray2 = array ++: list1

    println(newArray1)
    println(newArray2)

    val newList3: List[String] = list1 ::: list2
    println(newList3)
  }
  concat()

  def iterate() = {
    println("-- List の繰り返し処理 --")

    val list: List[String] = List("A", "B")

    for (e <- list) {
      println(e)
    }

    list.foreach { e =>
      println(e)
    }

    list.zipWithIndex.foreach { case(e: String, i: Int) =>
        println("%d: %s".format(i, e))
    }
  }
  iterate()

  def map() = {
    println("-- List の要素の変換 --")

    {
      val list = List("Java", "Scala", "Clojure")

      val newList = list.map {
        _.length
      }
      println(newList)
    }

    {
      val list1 = List(1, "A", 2, "B")
      val result1 = list1.collect { case e: String => e}

      println(result1)

      val list2 = List(1, 2, 3, 4)
      val result2 = list2.collect { case i if i >= 3 => i * 2}

      println(result2)
    }
  }
  map()

  def sort() = {
    println("-- List を並び替えたい --")

    val list1: List[Int] = List(2, 1, 4, 3)

    val sorted1: List[Int] = list1.sorted
    val sorted2: List[Int] = list1.sorted.reverse

    println(sorted1)
    println(sorted2)

    val list2: List[String] = List("Takako", "Naoki")

    val sorted3: List[String] = list2.sortWith { (a, b) => a.length < b.length }

    val sorted4: List[String] = list2.sortBy { _.length }

    println(sorted3)
    println(sorted4)

    case class Book(id: Int, name: String) extends Ordered[Book] {
      def compare(that: Book): Int = {
        id.compare(that.id)
      }
    }

    val books = List(
      Book(2, "現場で使えるJavaライブラリ"),
      Book(1, "Seasar2徹底入門"),
      Book(3, "Scala逆引きレシピ")
    )

    println(books.sorted)
  }
  sort()

  def mkString() = {
    println("-- List を文字列にしたい --")

    val list: List[String] = List("竹添直樹", "島本多可子")

    val str1: String = list.toString()
    println(str1)

    val str2: String = list. mkString
    println(str2)

    val str3: String = list.mkString("/")
    println(str3)

    val str4: String = list.mkString("Scala逆引きレシピ ", "/", " 著")
    println(str4)
  }
  mkString()
  
}

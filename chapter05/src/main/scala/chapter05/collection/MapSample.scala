package chapter05.collection

/**
 * @author tanabe
 */
object MapSample extends App {

  def create() = {
    println("-- Map を生成する --")

    val emptyMap = Map()
    println(emptyMap)

    val map = Map("key1" -> "value1", "key2" -> "value2")
    println(map)

    val get1 = map.get("key1")
    val get2 = map.get("key2")
    val get3 = map.get("key3")

    println(get1)
    println(get2)
    println(get3)

    val getOrElse1 = map.getOrElse("key1", "default-value")
    val getOrElse2 = map.getOrElse("key2", "default-value")
    val getOrElse3 = map.getOrElse("key3", "default-value")

    println(getOrElse1)
    println(getOrElse2)
    println(getOrElse3)

    val value1 = map("key1")
    val value2 = map("key2")
    println(value1)
    println(value2)

    try {
      val value3 = map("key3")
      println(value3)
    } catch {
      case e: Throwable => println(e.getMessage)
    }

    val contains1 = map.contains("key1")
    val contains3 = map.contains("key3")

    println(contains1)
    println(contains3)

    val symbolMap = Map('name -> "Naoki Takezoe",
                        'mail -> "takezoe@gmail.com")
    println(symbolMap('name))
    println(symbolMap('mail))
  }
  create()

  def foreach() = {
    println("-- Map の要素を繰り返し処理する --")

    val map = Map("key1" -> "value1", "key2" -> "value2")

    for ( (key, value) <- map ) {
      println(key + "=" + value)
    }

    map.foreach( e => println(e._1 + "=" + e._2 ))

    map.foreach { case (key, value) =>
        println(key + "=" + value)
    }

    map.keys.foreach { key => println(key) }

    map.values.foreach { value => println(value) }
  }
  foreach()

  def add() = {
    println("-- Map に要素を追加する --")

    val map = Map("key1" -> "value1", "key2" -> "value2")

    val newMap = map + ("key3" -> "value3", "key4" -> "value4")

    println(newMap)
  }
  add()

  def concat() = {
    println("-- Map を連結する --")
    val map1 = Map("key1" -> "value1") ++ Map("key2" -> "value2")
    println(map1)

    val map2 = Map("key1" -> "value1") ++ List(("key2","value2"))
    println(map2)

    val map3 = List(("key1","value1")) ++: Map("key2" -> "value2")
    println(map3)
  }
  concat()

  def remove() = {
    println("-- Map の要素を削除する --")

    val map = Map(
      "key1" -> "value1",
      "key2" -> "value2",
      "key3" -> "value3",
      "key4" -> "value4"
    )

    val removeMap1 = map - "key1"
    println(removeMap1)

    val removeMap2 = map - ("key2", "key3")
    println(removeMap2)

    val removeMap3 = map -- List("key1", "key2")
    println(removeMap3)

    val filteredMap1 = map.filter {
      case (key, value) => value.endsWith("1")
    }
    println(filteredMap1)

    val filteredMap2 = map.filterNot {
      case (key, value) => value.endsWith("2")
    }
    println(filteredMap2)
  }
  remove()

  def map() = {
    println("-- Map の要素を変換する --")

    val books = Map(
      1 -> "Seasar2徹底入門",
      2 -> "現場で使えるJavaライブラリ",
      3 -> "Scala逆引きレシピ"
    )

    val result1 = books.map { case(key, value) =>
      (key, "[" + value + "]")
    }
    println(result1)

    case class Book(id: Int, name: String)

    val result2 = books.map { case(key, value) =>
      Book(key, value)
    }
    println(result2)
  }
  map()

  def sort() = {
    println("-- ソートされた Map を使う --")

    {
      val books = Map(
        2 -> "現場で使えるJavaライブラリ",
        1 -> "Seasar2徹底入門",
        3 -> "Scala逆引きレシピ"
      )
      println(books)

      val sortedKeys = books.keys.toList.sorted
      println(sortedKeys)

      sortedKeys.foreach { key =>
        println("%d: %s".format(key, books(key)))
      }
    }

    {
      import scala.collection.immutable.SortedMap

      val books = SortedMap(
        2 -> "現場で使えるJavaライブラリ",
        1 -> "Seasar2徹底入門",
        3 -> "Scala逆引きレシピ"
      )

      books.foreach { case (key, value) =>
          println("%d: %s".format(key, value))
      }
    }
  }
  sort()

}

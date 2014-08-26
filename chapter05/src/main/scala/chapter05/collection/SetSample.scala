package chapter05.collection

/**
 * @author tanabe
 */
object SetSample extends App {

  {
    println("-- Set を生成 --")
    val set: Set[String] = Set("A", "B", "C", "D")
    println(set)

    println("-- 要素が含まれているかの確認 --")
    if (set.contains("A")) {
      println("Aが含まれています")
    }

    println("-- 要素の繰り返し処理 --")
    set.foreach(println)

    println("-- 要素を変換 --")
    val result: Set[Int] = set.map { _.length }
    println(result)

    println("-- 要素を追加した新しい Set を生成")
    val set2 = set + "D"
    println("set2=" + set2)

    println("-- 複数の要素を一度に追加 --")
    val set3 = set ++ Set("E", "F")
    println("set3=" + set3)

    println("要素を削除した新しい Set を生成")
    val set4 = set - "A"
    println("set4=" + set4)

    println("複数の要素を一度に削除")
    val set5 = set -- Set("B", "C")
    println("set5=" + set5)

    println("""要素をフィルタリング("E="以外を抽出)""")
    val set6 = set.filter { s => s != "E"}
    println("set6=" + set6)
  }

  {
    val set1 = Set(1, 2, 3)
    val set2 = Set(2, 3, 4)

    println("-- 席集合 --")
    println(set1 & set2)

    println("-- 和集合 --")
    println(set1 | set2)

    println("-- 差集合 --")
    println(set1 &~ set2)
  }

  {
    import scala.collection.immutable.SortedSet

    println("-- ソート済みの Set を生成 --")
    val sortedSet = SortedSet(2, 4, 3, 1)
    println(sortedSet)
    sortedSet.foreach(println)
  }

}

package chapter05.collection

/**
 * @author tanabe
 */
object ParallelSample extends App {

  {
    val range = 1 to 10

    val result1 = range.map { _ + 1 } reduceLeft { _ + _ }
    println(result1)

    val result2 = range.par.map { _ + 1 } reduceLeft { _ + _ }
    println(result2)
  }

  {
    import scala.collection.parallel.immutable._

    val parSet = ParSet(1, 2, 3)
    println(parSet)
    val set = parSet.seq
    println(set)

    val parMap = ParMap("key1" -> "value1", "key2" -> "value2")
    println(parMap)
    val map = parMap.seq
    println(map)
  }
}

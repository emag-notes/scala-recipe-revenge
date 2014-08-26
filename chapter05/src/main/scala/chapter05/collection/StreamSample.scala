package chapter05.collection

/**
 * @author tanabe
 */
object StreamSample extends App {

  val stream1 = Stream("A", "B", "C")
  println(stream1)

  val stream2 = "A" #:: "B" #:: "C" #:: Stream.empty
  println(stream2)

  try {
    val list = (0 to Integer.MAX_VALUE - 1).toList
    println(list)
  } catch {
    case e: OutOfMemoryError => println(e.getMessage)
  }

  val stream = (0 to Integer.MAX_VALUE - 1).toStream
  println(stream)

  import java.sql.ResultSet
  def fromResultSet(rs: ResultSet): Stream[(Int, String)] = {
    rs.next match {
      case false => Stream.empty
      case true => (rs.getInt("user_id"), rs.getString("user_name")) #:: fromResultSet(rs)
    }
  }

}

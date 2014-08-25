package chapter04.oop

/**
 * @author tanabe
 */
object StructuralTypeSample extends App {

  def using[T <: {def close()}, E](res: T)(f: T => E) = try {
    f(res)
  } finally {
    res.close()
  }

  val ds = new DummyDataSource

  using(ds.getConnection) { con =>
    using(con.prepareStatement("INSERT INTO ...")) { ps =>
      ps.executeUpdate
    }
  }
}

class DummyDataSource {
  def getConnection = new DummyConnection
}
class DummyConnection {
  def prepareStatement(sql: String) = new DummyPreparedStatement(sql)
  def close() = println("Connection をクローズ")
}
class DummyPreparedStatement(sql: String) {
  def executeUpdate = 1
  def close() = println("PreparedStatement をクローズ")
}

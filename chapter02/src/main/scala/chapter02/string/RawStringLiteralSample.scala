package chapter02.string

/**
 * @author tanabe
 */
object RawStringLiteralSample extends App {

  {
    val str: String ="""SELECT
                          user_id,
                          unsername
                        FROM users
                        ORDER BY user_id"""
    println(str)
  }

  {
    val str: String =
      """
        |SELECT
        |  user_id,
        |  username
        |FROM users
        |ORDER BY user_id
      """.stripMargin

    println(str)
  }

}

package chapter02.other

/**
 * @author tanabe
 */
object OptionSample extends App {

  println("-- 値がある場合 --")

  val option1: Option[String] = Option("test")
  println(option1)
  println("get=" + option1.get)
  println("isEmpty=" + option1.isEmpty)
  println("isDefined=" + option1.isDefined)

  println("-- 値がない場合 --")

  val option2: Option[String] = Option(null)
  println(option2)
  println("orNull=" + option2.orNull)
  println("isEmpty=" + option2.isEmpty)
  println("isDefined=" + option2.isDefined)

  println("getOrElse=" + option2.getOrElse("default value"))

  println("-- パターンマッチを使用して値を取得 --")
  val result2: String = option2 match {
    case Some(x) => x
    case None => "default value"
  }
  println(result2)

  println("-- Map#get メソッドは Option を返す --")

  val map: Map[String, String] =
    Map("key1" -> "value1", "key2" -> "value2")

  val option: Option[String] = map.get("key1")
  val value: String = option.get
  println(value)

  println("-- foreach メソッドを使って処理 --")

  val option3: Option[String] = None
  option3.foreach { value: String => println(value) }

  val option4: Option[String] = Some("value")
  option4.foreach { value: String => println(value) }

}

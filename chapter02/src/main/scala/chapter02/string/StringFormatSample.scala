package chapter02.string

/**
 * @author tanabe
 */
object StringFormatSample extends App {

  println("Hello %s!".format("Scala"))

  println("%2$sは%1$d文字以内で入力してください。".format(20, "お名前"))

  println("%04d/%02d/%02d".format(2014, 8, 22))
  println("%06.2f".format(10.0d))
}

package chapter03.function

/**
 * @author tanabe
 */
object CurryingSample extends App {

  println("-- 関数のカリー化 --")

  val greetfunc = (title: String) => (name: String) => title + " " + name

  println(greetfunc("Hello!")("Takako"))

  val hello = greetfunc("Hello!")
  println(hello("Naoki"))

  println("-- メソッドのカリー化 --")
  def greetdef(title: String)(name: String) = title + " " + name

  println(greetdef("Hello!")("Takako"))

  def greet(f: String => String) = f("Naoki")
  println(greet(greetdef("Hello!")))

  println("-- curried メソッドを使って関数をカリー化 --")
  val greetfunc2 = (title: String, name: String) => title + " " + name
  println(greetfunc2("Hello!", "Not Curried"))
  val curryfunc = greetfunc2.curried

  println(curryfunc("Hello!")("Takako"))

  println("-- curried メソッドを使ってメソッドをカリー化 --")
  def greetdef2(title: String, name: String) = title + " " + name
  val currydef = (greetdef2 _).curried

  println(currydef("Hello!")("Naoki"))

}

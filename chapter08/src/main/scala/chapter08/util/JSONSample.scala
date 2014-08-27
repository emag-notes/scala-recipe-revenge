package chapter08.util

/**
 * @author tanabe
 */
object JSONSample extends App {

  {
    println("-- dijon --")

    import com.github.pathikrit.dijon._

    val (name, age) = ("Tigri", 7)

    val cat = json"""
    {
      "name": "$name",
      "age": $age,
      "hobbies": ["eating", "purring"],
      "is cat": true
    }
  """
    println(cat.name)
    println(cat.age)
    println(cat.hobbies)
    println(cat.hobbies(0))
    println(cat.hobbies(1))
    println(cat.`is cat`)
  }

}

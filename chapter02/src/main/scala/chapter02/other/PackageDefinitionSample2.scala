package chapter02 {
  package other {
    class PackageDefinitionSample2 {}
  }
}

/**
 * @author tanabe
 */
object PackageDefinitionSample2 extends App {
  import chapter02.other.PackageDefinitionSample2
  println(classOf[PackageDefinitionSample2].getName)
}

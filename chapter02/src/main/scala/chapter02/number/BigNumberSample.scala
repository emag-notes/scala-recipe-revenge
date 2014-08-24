package chapter02.number

/**
 * @author tanabe
 */
object BigNumberSample extends App {

  {
    println("-- Int と BigInt の違い --")

    val i1 = 100000
    val i2 = 100000
    println("Int: " + (i1 * i2))

    val b1: BigInt = BigInt(100000)
    val b2: BigInt = BigInt(100000)
    println("BigInt: " + (b1 * b2))
  }

  {
    println("-- Double と BigDecimal の違い --")

    val d1 = 1.0
    val d2 = 0.1
    println("Double: " + (d1 + d2 + d2))

    val b1 = BigDecimal(1.0)
    val b2 = BigDecimal(.1)
    println("BigDecimal: " + (b1 + b2 + b2))
  }

  {
    println("-- 文字列から生成 --")

    val i = BigInt("9999999999")
    val d= BigDecimal("99999.999999999999")

    println("BigInt: " + i)
    println("BigDecimal: " + d)
  }

}

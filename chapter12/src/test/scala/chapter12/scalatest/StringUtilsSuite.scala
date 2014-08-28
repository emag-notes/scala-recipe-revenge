package chapter12.scalatest

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfter, FunSuite}

/**
 * @author tanabe
 */
class StringUtilsSuite extends FunSuite with BeforeAndAfter with BeforeAndAfterAll {

  override def beforeAll() = {
    println("** beforeAll **")
  }

  override def afterAll() = {
    println("** afterAll **")
  }

  before {
    println("** before **")
  }

  after {
    println("** after **")
  }

  test("StringUtils#isEmpty returns true for null") {
    assert(StringUtils.isEmpty(null))
  }

  test("StringUtils#isEmpty returns true for the empty string") {
    assert(StringUtils.isEmpty(""))
  }

  test("StringUtils#isEmpty returns false for any other strings") {
    assert(! StringUtils.isEmpty("a"))
  }
  
}

package chapter12.scalatest

import org.scalatest.FunSpec

/**
 * @author tanabe
 */
class StringUtilsSpec extends FunSpec {

  describe("StringUtils#isEmpty") {
    it("returns true for null") {
      assert(StringUtils.isEmpty(null))
    }

    it("returns true for the empty string") {
      assert(StringUtils.isEmpty(""))
    }

    it("returns false for any other strings") {
      assert(! StringUtils.isEmpty("a"))
    }
  }
}

package chapter12.scalatest

import org.scalatest.{FeatureSpec, GivenWhenThen, FunSuite}

/**
 * @author tanabe
 */
class StringUtilsFeatureSpec extends FeatureSpec with GivenWhenThen {

  feature("Tests whether a string is empty") {

    info("StringUtils#isEmpty checks whether the given strgin is empty or null.")
    info("'empty' means null or the empty string.")

    scenario("StringUtils#isEmpty is invoked with null") {
      Given("null")
      val value = null

      When("isEmpty is invoked")
      val result = StringUtils.isEmpty(value)

      Then("true should be returned")
      assert(result == true)
    }

    scenario("StringUtils#isEmpty is invoked with a empty string") {
      Given("a empty string")
      val value = ""

      When("isEmpty is invoked")
      val result = StringUtils.isEmpty(value)

      Then("true should be returned")
      assert(result == true)
    }

    scenario("StringUtils#isEmpty is invoked with a string other than null and empty") {
      Given("a string that is not null and empty")
      val value = "a"

      When("isEmpty is invoked")
      val result = StringUtils.isEmpty(value)

      Then("false should be returned")
      assert(result == false)
    }

  }
}

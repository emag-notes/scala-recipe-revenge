package chapter12.scalatest

/**
 * @author tanabe
 */
object StringUtils {

  def isEmpty(value: String): Boolean = {
    value == null || value.length() == 0
  }

}

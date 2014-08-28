package chapter12.specs2

/**
  * @author tanabe
  */
object StringUtils {

   def isEmpty(value: String): Boolean = {
     value == null || value.length() == 0
   }

 }

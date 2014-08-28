package chapter10.java;

import chapter10.javalink.ScalaClass;

/**
 * @author tanabe
 */
public class ScallCallSample {

  public static void main(String[] args) {
    ScalaClass scalaClass = new ScalaClass();

    try {
      scalaClass.output();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

package chapter10.javalink

/**
 * @author tanabe
 */
class SampleThread extends Thread {

  override def run() = {
    this.setPriority(Thread.MAX_PRIORITY)
    printf("SampleThread 実行")
  }

}

class SampleRunnable extends Runnable {

  override def run(): Unit = {
    println("SampleRunnable 実行")
  }

}

object Main extends App {

  val thread = new SampleThread
  thread.start()

  val runnable = new Thread(new SampleRunnable)
  runnable.start()

}

package chapter08.util

import scala.swing._

/**
 * @author tanabe
 */
object SwingSample extends SimpleSwingApplication {

  override def top: Frame = new MainFrame {
    title = "サンプル"
    preferredSize = new java.awt.Dimension(200, 100)
    contents = new Button() {
      action = Action("クリック") {
        Dialog.showMessage(
          title = "メッセージ",
          message = "Hello, Scala Swing!",
          messageType = Dialog.Message.Info
        )
      }
    }
  }

}

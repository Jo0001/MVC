import controller.Controller
import model.Counter
import view.Tui

/** Main: nur Zusammensetzung und Start. Keine Eingabelogik, keine Fachlogik. */
object Main {
  def main(args: Array[String]): Unit = {
    val model = new Counter
    val controller = new Controller(model)
    val tui = new Tui(controller)
    tui.run()
  }
}
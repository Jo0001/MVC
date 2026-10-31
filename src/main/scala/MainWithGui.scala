import controller.Controller
import model.Counter
import view.{Gui, Tui}
/** Erweiterte Main: dieselben Klassen Counter und Controller, eine View mehr. */
object MainWithGui {
  def main(args: Array[String]): Unit = {
    val model = new Counter
    val controller = new Controller(model)
    val gui = new Gui(controller) // meldet sich an
    val tui = new Tui(controller) // meldet sich an
    gui.show() // kehrt sofort zurück: Swing läuft im eigenen Event-Thread
    tui.run() // blockiert den main-Thread bis "q"
    sys.exit(0) // beendet auch den Swing-Thread
  }
}
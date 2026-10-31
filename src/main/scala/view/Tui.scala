package view
import controller.Controller
import util.Observer
import scala.io.StdIn
/** Die textbasierte View. Sie ist ein Observer, übersetzt Tastatureingaben
 * in Controller-Aufrufe und holt Daten ausschließlich über den Controller.
 */
class Tui(controller: Controller) extends Observer {
  controller.add(this)
  // Schritt 3 -> 4: wird vom Controller aufgerufen, holt dann die Daten
  def update: Unit =
    println(s"Wert: ${controller.value}")
  // Eigene Eingabeschleife (modalitätsspezifisch, blockiert bis "q")
  def run(): Unit = {
    println("Eingabe: + (hoch), - (runter), q (beenden)")
    update
    var input = StdIn.readLine()
    while (input != null && input.trim != "q") {
      processInput(input.trim)
      input = StdIn.readLine()
    }
  }
  // Schritt 1: Eingabe in modalitätsunabhängige Aktion übersetzen
  def processInput(input: String): Unit = input match {
    case "+" => controller.increase()
    case "-" => controller.decrease()
    case _ => println("Unbekannte Eingabe")
  }
}
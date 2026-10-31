package controller
import model.Counter
import util.Observable
/** Der Controller: nimmt modalitätsunabhängige Aktionen der View entgegen,
 * veranlasst Änderungen im Model und benachrichtigt danach alle Observer.
 * Er ist das Observable und kennt keine konkrete View.
 */
class Controller(model: Counter) extends Observable {
  // Aktionen (werden von der View aufgerufen)
  def increase(): Unit = {
    model.increment()
    notifyObservers
  }
  def decrease(): Unit = {
    model.decrement()
    notifyObservers
  }
  // Datenabruf (wird von der View aufgerufen, holt aus dem Model)
  def value: Int = model.get
}
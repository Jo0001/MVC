package util

/** Schnittstelle für alle, die über Änderungen informiert werden wollen.
 * Der Controller kennt nur dieses Interface, nie eine konkrete View.
 */
trait Observer {
  def update: Unit
}
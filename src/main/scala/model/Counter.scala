package model
object Counter {
  val Min: Int = 0
  val Max: Int = 10
}
/** Das Model: speichert den Zählerstand und garantiert den gültigen
 * Wertebereich 0 bis 10. Es kennt weder Controller noch View.
 */
class Counter {
  private var current: Int = Counter.Min
  def get: Int = current
  def increment(): Unit =
    if (current < Counter.Max) current += 1
  def decrement(): Unit =
    if (current > Counter.Min) current -= 1
}
package view

import controller.Controller
import util.Observer
import java.awt.FlowLayout
import javax.swing.{JButton, JFrame, JLabel, SwingUtilities, WindowConstants}

/** Zweite View (Swing). Auch sie ist ein Observer und kennt nur den Controller.
 * Swing bringt seine eigene Event-Loop (Event Dispatch Thread) mit.
 */
class Gui(controller: Controller) extends Observer {
  private val frame = new JFrame("Zaehler")
  private val label = new JLabel()
  controller.add(this)

  // Baut das Fenster im Swing-Thread auf und kehrt sofort zurück (blockiert nicht)
  def show(): Unit = SwingUtilities.invokeLater(() => {
    val plus = new JButton("+")
    val minus = new JButton("-")
    plus.addActionListener(_ => controller.increase()) // Trigger
    minus.addActionListener(_ => controller.decrease()) // Trigger
    frame.setLayout(new FlowLayout())
    frame.add(minus)
    frame.add(label)
    frame.add(plus)
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    frame.setSize(220, 90)
    refresh()
    frame.setVisible(true)
  })
  // Wird vom Controller aufgerufen, ggf.aus einem anderen Thread

  def update: Unit =
    SwingUtilities.invokeLater(() => refresh())

  // Muss im Swing-Thread laufen; holt Daten ausschließlich über den Controller
  private def refresh(): Unit =
    label.setText(s"Wert: ${controller.value}")
}
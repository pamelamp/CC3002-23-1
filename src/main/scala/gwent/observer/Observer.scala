package cl.uchile.dcc
package gwent.observer

trait Observer {
  def update(observable: Subject, value: Any): Unit
}

package cl.uchile.dcc
package gwent.observer

trait Subject {
  def addObserver(observer: Observer): Unit
  def notifyObservers(value: Any): Unit
}

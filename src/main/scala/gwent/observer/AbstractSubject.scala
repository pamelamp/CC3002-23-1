package cl.uchile.dcc
package gwent.observer

abstract class AbstractSubject extends Subject {
  private var observers: List[Observer] = Nil

  override def addObserver(observer: Observer): Unit = {
    observers = observer :: observers
  }

  override def notifyObservers(value: Any): Unit = {
    for (observer <- observers) {
      observer.update(this, value)
    }
  }
}

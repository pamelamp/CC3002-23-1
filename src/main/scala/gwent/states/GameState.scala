package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** Represents a state in the game, as a part of the State Design Pattern implementation.
 *
 * This class is a fundamental representation of a game state.
 * it provides a default behaviour for a state within the game, and should be extended
 * by other more specific states.
 * The 'context' parameter is used to transition between states.
 *
 * The constructor is protected, which prevents direct instantiation of this class, but
 * allows its use as a base class for other game states.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new game state with a given context.
 */
class GameState protected(val context: GameController) {
  /** Sets the state of the context to this state */
  context.state = this

  /** Transition the game state to [[PlayerTurnState]].
   *
   * This method should be overriden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toTurnState(): Unit = {
    transitionError("PlayerTurn")
  }

  /** Transition the game state to [[PhaseEnd]].
   *
   * This method should be overriden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toPhaseEnd(): Unit = {
    transitionError("PhaseEnd")
  }

  /** Throws an [[InvalidTransitionException]] with a message about an invalid transition.
   *
   * Notice that this uses [[getClass]] to print the name of the current class.
   * This is used to print the name of the current class, and not no check the type of
   * and object.
   *
   * @param targetState The name of the state that was attempted to transition to.
   * @throws InvalidTransitionException always.
   */
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}

class InvalidTransitionException(message: String) extends Exception(message)

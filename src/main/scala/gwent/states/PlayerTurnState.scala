package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** Represents the player turn state in the game, as part of the State Design Pattern implementation.
 *
 * In the 'PlayerTurnState', the game is waiting for any input from the player.
 * It provides a specific implementation of the [[GameState]] for when the player is
 * deciding their next action.
 *
 * The 'context' parameter is used to transition between states, either to
 * 'PCTurnState' when the game is performing the programmed action of the computer, or to
 * 'EndPhase' when the game is performing corresponding steps to discount gems.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new player turn state with a given context.
 */
class PlayerTurnState(context: GameController) extends GameState(context) {

  /** Transition the game state from [[PlayerTurnState]] to [[PCTurnState]] or [[EndPhase]].
   *
   * This method changes the game state to 'PCTurnState' and prompts the predetermined
   * actions the PC can do on its turn via the 'context'.
   */
  override def toPCTurnState(): Unit = {
    context.state = new Interlude(context)
  }

  /** Transition the game state from [[PlayerTurnState]] to [[EndPhase]].
   *
   * This method changes the game state to 'PhaseEnd' via the 'context'.
   */
  override def toEndPhase(): Unit = {
    context.state = new PhaseEnd(context)
  }
}

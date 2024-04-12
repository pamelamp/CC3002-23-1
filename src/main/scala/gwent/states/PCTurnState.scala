package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** Represents the pc turn state in the game, as part of the State Design Pattern implementation.
 *
 * In the 'PCTurnState', the game is proceeding with the computer's programmed actions.
 *
 * The 'context' parameter is used to transition between states, either to
 * 'PlayerTurnState' when the player's turn begins, or to 'EndPhase' when the game is
 * performing corresponding steps to discount gems.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new pc turn state with a given context.
 */
class PCTurnState(context: GameController) extends GameState(context) {

}

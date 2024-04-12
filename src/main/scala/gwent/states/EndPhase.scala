package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** Represents the end phase state in the game, as part of the State Design Pattern implementation.
 *
 * In the 'PhaseEnd' state, the game is performing the actions that determine the winner
 * of the round, and discounts gems accordingly.
 *
 * The 'context' parameter is used to transition between states
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new end phase state with given context.
 */
class EndPhase(context: GameController) extends GameState(context) {

}

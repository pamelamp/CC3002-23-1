package cl.uchile.dcc
package gwent

import gwent.cards._

import cl.uchile.dcc.gwent.observer.Observer

/** A game controller for managing the player's actions and states in the game.
 *
 * This class is the core of the game and handles the transition of states, weather
 * changes, and player's actions.
 *
 */
class GameController extends Observer {

  /** The instance of the player currently in the game.
   * Initially it's not initiated.
   */
  private var user: Player = _
  /** The player's name.
   * The player may type their choice of name, which will be showed on the screen.
   */
  val username: String = scala.io.StdIn.readLine()

  /** The instance of the computer currently in the game.
   * Initially it's not initiated.
   */
  private var pc: Player = _

  /** Current state of the game.
   * Initially is set to
   */
  var state = new unknownState()

  /** Starts a new game with a specified user and a generic PC.
   *
   * This method initializes the game by creating a player and the computer.
   *
   * @param user
   * @param pc
   */
  def startGame(user: Player, pc: Player): Unit = {
    this.addPlayer(username)
    this.addPC()
  }

  /** Adds a new player.
   *
   * @param name The name of the player.
   */
  def addPlayer(name: String): Unit = {
    user = new Player(
      name, _gems = 2, _field = new Field(), _deck = ???, _hand = List())
  }

  /** Adds a new computer.
   *
   * The computer is the opponent of the user in the Gwen't game. This method creates
   * this opponent with a fixed deck and default name.
   */
  def addPC(): Unit = {
    pc = new Player(
      name = "Computer", _gems = 2, _field = new Field(), _deck = ???, _hand = List())
  }
}

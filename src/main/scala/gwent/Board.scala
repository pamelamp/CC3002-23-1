package cl.uchile.dcc
package gwent
import gwent.cards._


/** Class representing the board in the Gwen't game.
 *
 * A board takes no parameters, but its characterized by [[playerField]], [[pcField]],
 * and [[weather]].
 * Each of this variables are private.
 */
class Board() {

  /** Field of the first player.
   *
   * This variable holds the field of the first player currently in the game, and
   * contains exclusively cards of the first player.
   * Initially, the field is empty.
   * When the first player plays a unit card, this variable is changed to match the
   * changes made by the player.
   */
  private var playerField: Field = new Field()

  /** Field of the PC.
   *
   * This variable holds the field of the PC currently in the game, and
   * contains exclusively cards of the second player.
   * Initially, the field is empty.
   * When the PC plays a unit card, this variable is changed to match the
   * changes made by the PC.
   */
  private var pcField: Field = new Field()

  /** Current weather.
   *
   * This variable represents the weather that's currently affecting the cards on the
   * board.
   * Initially there is no card, thus being [[None]] at the beginning.
   * When a player plays a [[WeatherCard]] on their turn, this variable changes to
   * represent the played card.
   */
  private var weather: Option[WeatherCard] = None

  /** Accessor method for the weather card slot */
  var currentWeather: WeatherCard = _


  /** Sets a new [[WeatherCard]] on the board.
   *
   * @param weatherCard The weather card that will be placed on the board.
   */
  def setWeather(weatherCard: WeatherCard): Unit = {
    weather = Some(weatherCard)
    currentWeather = weatherCard
  }

  /** Checks if the weather card slot is empty.
   *
   * This method revises if there is a weather card affecting the battlefield.
   *
   * @return Boolean asserting that the weather card slot is empty or not.
   */
  def noWeatherCard(): Boolean = {
    if (weather.canEqual(None)){
      println("There is no weather card on the board.")
      true}
    else {
      println("Special weather in effect.")
      false}
  }

  def getWeather(): WeatherCard = currentWeather


  /** Checks if the board is empty or not.
   *
   * This method revises both fields and the weather card slot to check if there are
   * cards on the board or not.
   *
   * @return Boolean asserting that the board is empty or not.
   */
  def emptyBoard(): Boolean = {
    // Is the player's field empty?
    val playerFieldStatus: Boolean = playerField.fieldIsEmpty()

    // Is the PC's field empty?
    val pcFieldStatus: Boolean = pcField.fieldIsEmpty()

    // Are both fields empty?
    val emptyFields: Boolean = playerFieldStatus && pcFieldStatus

    // Is the weather card slot empty?
    val emptyWeatherSlot: Boolean = this.noWeatherCard()

    // Is the whole board empty?
    val emptiness: Boolean = emptyFields && emptyWeatherSlot

    // Cases
    if (emptiness) {println("There are no cards in the board.")}
    else {println("There are cards on the board.")}

    // Finally, returns the truth value
    emptiness
  }
}

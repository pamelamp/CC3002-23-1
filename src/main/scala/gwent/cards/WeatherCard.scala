package cl.uchile.dcc
package gwent.cards

/** Class representing a weather card in the Gwen't game.
 *
 * A `WeatherCard` is a type of [[Card]] that can be placed in the weather zone.
 * These cards have the ability to affect the battlefield and provide advantages or
 * disadvantages to players, depending on the type of weather that has been chosen.
 *
 * @constructor Creates a new weather card with a specified name and description.
 * @param name The name of the card.
 * @param description The description of the card, explaining its specific effects.
 */
class WeatherCard(val name: String,
                  val description: String) extends Card {

  def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]
}

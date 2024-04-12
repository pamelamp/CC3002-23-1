package cl.uchile.dcc
package gwent.cards

/** Trait representing a card in the Gwen't game.
 *
 * A card is characterized by its [[name]] and [[description]].
 * This trait serves as a common interface for all card types and ensures that every card,
 * regardless of its specific subtype, will have these basic properties.
 *
 * The ``val`` keyword in the property declarations indicates that these properties are
 * immutable -- once a card has been created with a certain name and description, these
 * cannot be changed.
 * This reflects the real-world behaviour of game cards, which have fixed names and
 * descriptions printed on them.
 *
 * The actual content of these properties, as well as any additional properties or
 * behaviours, are to be defined in the concrete classes that extend this trait.
 */
trait Card {

  /** The name of the card.
   * This is and immutable property.
   */
  val name: String

  /** A description of the card's properties of effects.
   * This is an immutable property.
   */
  val description: String

}

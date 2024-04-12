package cl.uchile.dcc
package gwent.cards

/** Abstract class representing a unit card in the Gwen't game.
 *
 * An `AbsUnitCard` is a type of [[Card]] that has a power value which contributes to
 * the player's total power in the game.
 * Each unit card starts with its current power equal to its base power.
 *
 * @constructor Creates a new `AbsUnitCard` with a specified name, description, and power.
 * @param name The name of the card.
 * @param description The description of the card, explaining its specific abilities or
 *                    roles in the game.
 * @param power The base power of the card, indicating the contribution of this card to
 *              the player's total power when unaffected by any special conditions.
 */
abstract class AbsUnitCard(override val name: String,
                           val description: String,
                           var power: Int)
  extends Card with Equals {

  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[power]] of the card.
   */
  var currentPower: Int = power

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[AbsUnitCard]
      (this eq other) || (name == other.name)
    } else false
  }

  override def toString: String = {
    s"""Class: ${getClass.getName}
       |Name: $name
       |Effect: $description
       |Power: $currentPower""".stripMargin
  }
}

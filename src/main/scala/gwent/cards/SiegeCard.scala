package cl.uchile.dcc
package gwent.cards

/** Class representing a siege combat unit card in the Gwen't game.
 *
 * A `SiegeCard` is a type of [[AbsUnitCard]].
 * These cards represent siege machinery used on the battlefield.
 * As per the game's rules, these cards can only be placed in the siege combat zone.
 *
 * @constructor Creates a new siege combat card with a name, description, and power.
 * @param name The name of the card.
 * @param description The description of the card.
 * @param power The initial power value of the card, which also corresponds to the
 *              siege machinery's strength.
 */
class SiegeCard(name: String,
                description: String,
                power: Int)
  extends AbsUnitCard(name, description, power) {

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[SiegeCard]
  }

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[SiegeCard]
      (this eq other) || (name == other.name)
    } else false
  }
}

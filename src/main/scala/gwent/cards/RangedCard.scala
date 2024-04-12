package cl.uchile.dcc
package gwent.cards

/** Class representing a ranged combat unit card in the Gwen't game.
 *
 * A `RangedCard` is a type of [[AbsUnitCard]].
 * These cards represent troops that engage in ranged combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the ranged combat zone.
 *
 * @constructor Creates a new ranged combat card with a name, description, and power.
 * @param name The name of the card.
 * @param description The description of the card.
 * @param power The initial power of the card, which also corresponds to the
 *              strength of the troop it represents.
 */
class RangedCard(name: String,
                 description: String,
                 power: Int)
  extends AbsUnitCard(name, description, power) {

  def canEqual(that: Any): Boolean = {
    that.isInstanceOf[RangedCard]
  }

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[RangedCard]
      (this eq other) || (name == other.name)
    } else false
  }
}

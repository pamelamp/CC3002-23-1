package cl.uchile.dcc
package gwent
import gwent.cards._

/** Class representing a field in the Gwen't game.
 *
 * A field takes no parameters, but its characterized by its [[CloseCombatLine]],
 * [[RangedCombatLine]], and [[SiegeCombatLine]].
 * Each of this variables are private, but can be accessed via their corresponding
 * getter methods.
 * We use immutable lists instead of mutable ones to represent every variable.
 */
class Field() {

  /** Field line containing close combat unit cards.
   *
   * This variable represents the close combat line of the field, and can contain
   * exclusively cards of the [[CloseCombatCard]] type.
   * Initially, this list is empty.
   * When a [[CloseCombatCard]] card is played, this variable is changed to a new list,
   * which is the result of concatenating the played card and the original list.
   */
  private var CloseCombatLine: List[CloseCombatCard] = List()

  /** Field line containing ranged combat unit cards.
   *
   * This variable represents the ranged combat line of the field, and contains
   * exclusively cards of the [[RangedCard]] type.
   * Initially, this list is empty.
   * When a [[RangedCard]] card is played, this variable is changed to a new list,
   * which is the result of concatenating the played card and the original list.
   */
  private var RangedCombatLine: List[RangedCard] = List()

  /** Field line containing siege combat unit cards.
   *
   * This variable represents the siege combat line of the field, and can contain
   * exclusively cards of the [[SiegeCard]] type.
   * Initially, this list is empty.
   * When a [[SiegeCard]] is played, this variable is changed to a new list,
   * which is the result of concatenating the played card and the original list.
   */
  private var SiegeCombatLine: List[SiegeCard] = List()

  /** Card slot where a weather card is placed.
   *
   * This variable represents a slot where a player places a weather card (when they
   * play one), and may hold exclusively a single [[WeatherCard]].
   *
   * The purpose of this slot is simplifying the operation of the game's board.
   */
  private var WeatherCardSlot: Option[WeatherCard] = None

  /** Accessor method for the close combat line */
  def close: List[CloseCombatCard] = CloseCombatLine

  /** Accessor method for the ranged combat line */
  def ranged: List[RangedCard] = RangedCombatLine

  /** Accessor method for the siege combat line */
  def siege: List[SiegeCard] = SiegeCombatLine

  /** Places a [[CloseCombatCard]] on the field.
   *
   * @param card The close combat card that will be placed on the close combat line.
   */
  def placeCard(card: CloseCombatCard): Unit = {
    CloseCombatLine = card :: close
  }

  /** Places a [[RangedCard]] on the field.
   *
   * @param card The ranged combat card that will be placed on the ranged combat line.
   */
  def placeCard(card: RangedCard): Unit = {
    RangedCombatLine = card :: ranged
  }

  /** Places a [[SiegeCard]] on the field.
   *
   * @param card The siege combat card that will be placed on the siege combat line.
   */
  def placeCard(card: SiegeCard): Unit = {
    SiegeCombatLine = card :: siege
  }

  /** Places a [[WeatherCard]] on the field.
   *
   * @param card The waether card that will be placed on the weather card slot.
   */
  def placeCard(card: WeatherCard): Unit = {
    WeatherCardSlot = Some(card)
  }

  /** Checks if the close combat line is empty.
   *
   * This method revises if the close combat line has any cards on it.
   *
   * @return Boolean asserting that the close combat line is empty or not.
   */
  def emptyCloseCombatLine(): Boolean = {
    val status: Boolean = close.isEmpty
    if (status) {println("The close combat zone is empty")}
    else {println("The close combat zone is not empty")}
    status
  }

  /** Checks if the ranged combat line is empty.
   *
   * This method revises if the ranged combat line has any cards on it.
   *
   * @return Boolean asserting that the ranged combat line is empty or not.
   */
  def emptyRangedCombatLine(): Boolean = {
    val status: Boolean = ranged.isEmpty
    if (status) {println("The ranged combat zone is empty")}
    else {print("The ranged combat zone is not empty")}
    status
  }

  /** Checks if the siege combat line is empty.
   *
   * This method revises if the siege combat line has any cards on it.
   *
   * @return Boolean asserting that the siege combat line is empty or not.
   */
  def emptySiegeCombatLine(): Boolean = {
    val status: Boolean = siege.isEmpty
    if (status) {println("The siege combat zone is empty.")}
    else {println("The siege combat zone is not empty.")}
    status
  }

  /** Checks if the field is empty or not.
   *
   * This method revises every line of the field to check if there are cards on the
   * field or not.
   *
   * @return Boolean asserting that the field is empty or not.
   */
  def fieldIsEmpty(): Boolean = {
    // CCL: Close Combat Line
    val CCL: Boolean = this.emptyCloseCombatLine()
    // RCL: Ranged Combat Line
    val RCL: Boolean = this.emptyRangedCombatLine()
    // SCL: Siege Combat Line
    val SCL: Boolean = this.emptySiegeCombatLine()
    // linesStatus es 'true' si no hay cartas de unidad, 'false' en caso contrario
    val linesStatus: Boolean = CCL && RCL && SCL
    val emptyWeatherSlot: Boolean = true
    val globalStatus: Boolean = CCL && RCL && SCL
    if (globalStatus) {println("The field is empty.")}
    else {println("The field has cards on it.")}
    globalStatus
  }

  /** Erases every card on the field.
   *
   * This method clears the field when required, eliminating every card on it by creating
   * new lists for every list associated with a line of the field.
   */
  def clearField(): Unit = {
    CloseCombatLine = List()
    RangedCombatLine = List()
    SiegeCombatLine = List()
    WeatherCardSlot = None
  }



}

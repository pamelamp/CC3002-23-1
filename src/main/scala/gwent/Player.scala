package cl.uchile.dcc
package gwent

import gwent.cards._

import cl.uchile.dcc.gwent.observer.AbstractSubject

import scala.collection.mutable.ListBuffer


/** Class representing a player in the Gwen't game.
 *
 * Each player has a name, a gem counter, a (battle)field, a deck of cards, and
 * hand of cards.
 * The gems, field, deck, and hand are protected variables, but can be
 * accessed via their corresponding getter methods.
 * We use immutable lists instead of mutable ones to represent the field, deck, and hand.
 *
 * @constructor Creates a new player with a name, gem counter, field, deck, and hand.
 * @param name The name of the player.
 * @param _gems The initial gem count for the player.
 * @param _field The zone where the player places cards.
 * @param _deck The initial list of cards in the player's deck.
 * @param _hand The initial list of cards in the player's hand.
 */
class Player(val name: String,
                      protected var _gems: Int,
                      protected var _field: Field,
                      protected var _deck: List[Card],
                      protected var _hand: List[Card]) extends AbstractSubject {

  /** Accessor method for the player's total gems */
  def gems: Int = _gems

  /** Accessor method for the player's field */
  def field: Field = _field

  /** Accessor method for the player's deck */
  def deck: List[Card] = _deck

  /** Accessor method for the player's hand */
  def hand: List[Card] = _hand

  /** Deducts a gem from the player.
   *
   * @return The new amount of gems the player has.
   */
  def roundLost(): Unit = {
    _gems = gems - 1
    gems
  }

  /** Shows the player's cards on their Close Combat Zone.
   *
   * @return List with the cards on the player's Close Combat Zone.
   */
  def seeCloseCombatZone(): List[CloseCombatCard] = {
    field.close
  }

  /** Shows the player's cards on their Ranged Combat Zone.
   *
   * @return List with the cards on the player's Ranged Combat Zone.
   */
  def seeRangedCombatZone(): List[RangedCard] = {
    field.ranged
  }

  /** Shows the player's cards on their Siege Combat Zone.
   *
   * @return List with the cards on the player's Siege Combat Zone.
   */
  def seeSiegeCombatZone(): List[SiegeCard] = {
    field.siege
  }

  /** Checks if the player's field is empty or not.
   *
   * This method checks if the player's field has any card on it, revising every combat
   * line on the field.
   *
   * @return Boolean asserting that the field is empty or not.
   */
  def fieldStatus(): Boolean = {
    field.fieldIsEmpty()
  }

  /** Draws a card from the deck and adds it to the hand.
   *
   * The top card from the deck is removed and added to the player's hand.
   * This method also returns the drawn card.
   *
   * Note: as lists are immutable, when we "remove" a card from the deck or "add" one to
   * the hand, what we're actually doing is creating a new list with teh desired contents
   * and reassigning the _deck or _hand variable to this new list.
   *
   * @return The card that was drawn from the deck.
   */
  def draw(): Card = {
    val card = deck.head
    _deck = deck.tail
    _hand = card :: hand
    card
  }

  /** Shuffles the player's deck.
   *
   * The order of cards in the player's deck is randomized.
   * This is achieved by creating a new, shuffled list and reassigning _deck to it, rather
   * than by modifying the original list.
   */
  def shuffleDeck(): Unit = {
    _deck = scala.util.Random.shuffle(_deck)
  }

  /** Counts the number of cards remaining in the player's deck.
   *
   * A deck has 25 cards, and it's useful for the player to know how many cards their
   * deck has left, to properly plan their strategy.
   *
   * @return The number of cards left in the player's deck.
   */
  def deckSize(): Int = {
    val deckSize: Int = deck.length
    deckSize
  }

  /** Counts the number of cards in the player's hand.
   *
   * The player's hand can have up to 10 cards simultaneously, so the player shouldn't
   * draw more cards when they reach this limit.
   *
   * @return The number of cards in the player's hand.
   */
  def handSize(): Int = {
    val handSize: Int = hand.length
    handSize
  }

  /** Removes a card from the player's hand.
   *
   * Everytime a card is played from the player's hand, it must be removed from it,
   * ensuring it won't be used more than once on the game.
   *
   * This method uses [[ListBuffer]] to easily remove a single card from the hand, but
   * it has its limitations: it deletes the first instance of the card in the hand. If a
   * player has the exact same card twice in their hand and wants to play the "second
   * one", the first card will be played and removed instead.
   *
   * @param card The card that's about to be removed.
   * @return The card that was removed from the hand.
   */
  private def removeCard(card: Card): Card = {
    var tempHand: List[Card] = hand.head :: hand.tail
    var transientHand: ListBuffer[Card] = tempHand.to(ListBuffer)
    transientHand -= card
    val newHand: List[Card] = transientHand.toList
    _hand = newHand
    card
  }

  /** Places a [[CloseCombatCard]] on the player's field.
   *
   * A player can choose to play a unit card from their hand on their turn, and place it
   * on it's corresponding zone.
   *
   * This method invokes the [[Field]] object's method of the same name and parameters.
   *
   * @param card The close combat card that's been played.
   * @return The card that was played.
   */
   def playCard(card: CloseCombatCard): CloseCombatCard = {
    this.removeCard(card)
    _field.placeCard(card)
    card
  }

  /** Places a [[RangedCard]] on the player's field.
   *
   * A player can choose to play a unit card from their hand on their turn, and place it
   * on it's corresponding zone.
   *
   * This method invokes the [[Field]] object's method of the same name and parameters.
   *
   * @param card The ranged combat card that's been played.
   * @return The card that was played.
   */
  def playCard(card: RangedCard): RangedCard = {
    this.removeCard(card)
    _field.placeCard(card)
    card
  }

  /** Places a [[SiegeCard]] on the player's field.
   *
   * A player can choose to play a unit card from their hand on their turn, and place it
   * on it's corresponding zone.
   *
   * This method invokes the [[Field]] object's method of the same name and parameters.
   *
   * @param card The siege combat card that's been played.
   * @return The card that was played.
   */
  def playCard(card: SiegeCard): SiegeCard = {
    this.removeCard(card)
    _field.placeCard(card)
    card
  }

  /** Places a [[WeatherCard]] on the player's field.
   *
   * A player can choose to play a weather card from their hand on their turn, and place
   * it on the weather card slot.
   *
   * This method invokes the [[Field]] object's method of the same name and parameters.
   *
   * @param card The weather card that's been played.
   * @return The card that was played.
   */
  def playCard(card: WeatherCard): WeatherCard = {
    this.removeCard(card)
    _field.placeCard(card)
    card
  }

  /** Erases every card on the player's field.
   *
   * This method clears the player's field when required, eliminating every card on it.
   *
   * This method invokes the [[Field]] object's method of the same name.
   */
  def clearField(): Unit = {
    _field.clearField()
  }

}

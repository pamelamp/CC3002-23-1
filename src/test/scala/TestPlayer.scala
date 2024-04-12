package cl.uchile.dcc
package gwent
import gwent.cards._

class TestPlayer extends munit.FunSuite {
  val c1: CloseCombatCard = new CloseCombatCard("test", "No effect", 3)
  val c2: WeatherCard = new WeatherCard("clima", "Escarcha")
  val c3: RangedCard = new RangedCard("test2", "No effect", 4)
  val name = "Tester"
  val gem = 2
  var field: Field = new Field()
  var deck: List[Card] = List(c1,c2,c3)
  var hand: List[Card] = List()
  var player: Player = _
  override def beforeEach(context: BeforeEach): Unit = {
    player = new Player(name,gem,field,deck,hand)
  }
  test(name = "Datos básicos del jugador antes de iniciar la partida"){
    assertEquals(player.name, expected = "Tester")
    assertEquals(player.fieldStatus(), expected = true)
    assertEquals(player.gems, expected = 2)
    assertEquals(player.deckSize(), expected = 3)
    assertEquals(player.handSize(), expected = 0)
  }
  //Inicia la partida
  test(name = "Inicio de la partida"){
    println(player.deck)
    player.shuffleDeck()
    println(player.deck)
    player.draw()
    assertEquals(player.deckSize(), expected = 2)
    assertEquals(player.handSize(), expected = 1)
  }
  //Turno del jugador, usando un jugador con datos específicos
  var player1 = new Player("Tester 2", 2, new Field(), List(c1,c2), List(c3))
  test(name = "Jugar una carta"){
    player1.playCard(c3)
    assertEquals(player1.handSize(), expected = 0)
    assertEquals(player1.seeRangedCombatZone(), List(c3))
  }
  //Fin de partida; derrota forzada del jugador original
  test(name = "Jugador perdió la partida"){
    player.roundLost()
    player.roundLost()
    assertEquals(player.gems, expected = 0)
  }
}

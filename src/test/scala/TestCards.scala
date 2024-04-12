package cl.uchile.dcc
package gwent.cards

class TestCards extends munit.FunSuite{
  val c1 = new CloseCombatCard(name = "Vikingo", description = "No effect", power = 4)
  val c2 = new RangedCard(name = "Cocatriz", description = "No effect", power = 2)
  val c3 = new SiegeCard(name = "Catapulta", description = "No effect", power = 8)
  val c4 = new CloseCombatCard(name = "Geralt de Rivia", description = "Refuerzo moral", power = 15)
  val c5 = new RangedCard(name = "Sova", description = "No effect", power = 15)
  val c6 = new SiegeCard(name = "Turret", description = "No effect", power = 5)
  test(name = "Las cartas de unidad son diferenciables según su caracterización") {
    assertEquals(c1.equals(c2), expected = false)
    assertEquals(c1.equals(c3), expected = false)
    assertEquals(c1.equals(c4), expected = false)
    assertEquals(c2.equals(c3), expected = false)
    assertEquals(c2.equals(c4), expected = false)
    assertEquals(c3.equals(c4), expected = false)
  }
  test(name = "Las cartas de unidad son equiparables según su clasificación"){
    assertEquals(c1.canEqual(c4), expected = true)
    assertEquals(c2.canEqual(c5), expected = true)
    assertEquals(c3.canEqual(c6), expected = true)
  }
}

package cl.uchile.dcc
package gwent
import gwent.cards._

class TestBoard extends munit.FunSuite{
  var testBoard1 : Board = new Board()
  var testBoard2 : Board = new Board()
  var testBoard3 : Board = new Board()
  val niebla = new WeatherCard("Niebla potente", "Niebla impenetrable")
  val lluvia = new WeatherCard("Llueve sobre la ciudad", "Lluvia torrencial")
  test(name = "El tablero inicia vacío"){
    assertEquals(testBoard1.emptyBoard(), expected = true)
  }
  //Jugar una carta de clima
  testBoard2.setWeather(niebla)
  test(name = "Cada carta puede colocarse sólo en su zona correspondiente"){
    assertEquals(testBoard2.noWeatherCard(), expected = false)
    assertEquals(testBoard2.emptyBoard(), expected = false)
    assertEquals(testBoard2.getWeather(), expected = niebla)
  }
  //Jugar una carta de clima tras otra
  testBoard3.setWeather(niebla)
  testBoard3.setWeather(lluvia)
  test(name = "Jugar una nueva carta climática debería descartar la ya existente"){
    assertEquals(testBoard3.getWeather(), expected = lluvia)
  }
}

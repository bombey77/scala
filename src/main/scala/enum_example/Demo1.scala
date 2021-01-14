package enum_example

object Demo1 {

  def main(args: Array[String]): Unit = {
    println(Planets.Mercury.id) // 0
    println(Planets.Venus.id) // 1
    println(Planets.Mars.toString) // Mars
    println(Planets.Mars == Planets.Mars) // true
    println(Planets.Mars == Planets.Mercury) // false

    println(GreekPlanets.Mercury.id) // 1
    println(GreekPlanets.Venus.id) // 2
    println(GreekPlanets.Mars.toString) // "Ares"
    println(GreekPlanets.Mars == GreekPlanets.Mars) // true
    println(GreekPlanets.Mars == GreekPlanets.Mercury) // false

    println(Planet.Earth.id) // 2

    println(PlanetsVal.Earth.mass) // 5.976E24
    println(PlanetsVal.Earth.radius) // 6378140.0
  }
}

object Planets extends Enumeration {

  val Mercury = Value
  val Venus = Value
  val Earth = Value
  val Mars = Value
  val Jupiter = Value
  val Saturn = Value
  val Uranus = Value
  val Neptune = Value
  val Pluto = Value
}

// You can create an enumeration with your own index and your own Strings, in this exercise we will start
// with an index of one and use Greek names instead of Roman
object GreekPlanets extends Enumeration {

  val Mercury = Value(1, "Hermes")
  val Venus = Value(2, "Aphrodite")
  val Earth = Value(3, "Gaia")
  val Mars = Value(4, "Ares")
  val Jupiter = Value(5, "Zeus")
  val Saturn = Value(6, "Cronus")
  val Uranus = Value(7, "Ouranus")
  val Neptune = Value(8, "Poseidon")
  val Pluto = Value(9, "Hades")
}

//Enumerations can be declared in one line if you are merely setting variables to Value
object Planet extends Enumeration {
  val Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune, Pluto = Value
}

//Enumerations can be declared with a string value only
object GreekPlanet extends Enumeration {

  val Mercury = Value("Hermes")
  val Venus = Value("Aphrodite")
  val Earth = Value("Gaia")
  val Mars = Value("Ares")
  val Jupiter = Value("Zeus")
  val Saturn = Value("Cronus")
  val Uranus = Value("Ouranus")
  val Neptune = Value("Poseidon")
  val Pluto = Value("Hades")
}

//You can extend the Enumeration by extending the Val class
object PlanetsVal extends Enumeration {

  val G = 6.67300e-11

  class PlanetValue(val i: Int, val name: String, val mass: Double, val radius: Double)
    extends Val(i: Int, name: String) {

    def surfaceGravity = G * mass / (radius * radius)

    def surfaceWeight(otherMass: Double) = otherMass * surfaceGravity

    def compare(that: PlanetValue) = this.i - that.i
  }

  val Mercury = new PlanetValue(0, "Mercury", 3.303e+23, 2.4397e6)
  val Venus = new PlanetValue(1, "Venus", 4.869e+24, 6.0518e6)
  val Earth = new PlanetValue(2, "Earth", 5.976e+24, 6.37814e6)
  val Mars = new PlanetValue(3, "Mars", 6.421e+23, 3.3972e6)
  val Jupiter = new PlanetValue(4, "Jupiter", 1.9e+27, 7.1492e7)
  val Saturn = new PlanetValue(5, "Saturn", 5.688e+26, 6.0268e7)
  val Uranus = new PlanetValue(6, "Uranus", 8.686e+25, 2.5559e7)
  val Neptune = new PlanetValue(7, "Neptune", 1.024e+26, 2.4746e7)
  val Pluto = new PlanetValue(8, "Pluto", 1.27e+22, 1.137e6)
}
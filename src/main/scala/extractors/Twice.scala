package extractors

object Twice {
  def apply(x: Int): Int = x * 2

  def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
}

object TwiceTest extends App {
  val x = Twice(21)
  x match {
    case Twice(n) => Console.println(n)
  } // prints 21

  val Human(n, s) = new Person("Roman", "Moto")
  println(n) // Roman
  println(s) // Moto

  //  An extractor can also be used in pattern matching
  val person = new Person("Kathy", "Moto") match {
    case Human(n, s) => (n, s)
    case _ => ("name", "sureName")
  }
  println(person._1) // Kathy

  val glass = new Glass(123, "black shark") match {
    case Car(id, model) => (id, model)
    case _ => (0, "default")
  }
  println(glass._1) // 123
  println(glass._2) // black shark

  //  An extractor can be any stable object, including instantiated classes with an unapply method
  val automobile = new Automobile("Roman", "Mercedes")
  val auto = automobile match {
    case automobile(driver, model) => (driver, model)
    case _ => ("autopilot", "tesla")
  }
  println(auto._1) // autopilot
  println(auto._2) // tesla

  //  A custom extractor is typically created in the companion object of the class. In this exercise,
  //  we use it as an assignment:
  val singri = new Employee ("Singri", None, "Keerthi")
  val Employee (a, b, c) = singri
  println(a) // Keerthi
  println(b) // None
  println(c) // Singri
}

class Person(val name: String, val sureName: String)

object Human {
  def unapply(p: Person): Some[(String, String)] = Some((p.name, p.sureName))
}

//As long as the method signatures aren't the same, you can have as many unapply methods as you want
object Car {
  def unapply(p: Person): Some[(String, String)] = Some((p.name, p.sureName))

  def unapply(g: Glass): Some[(Int, String)] = Some((g.id, g.model))
}

class Glass(val id: Int, val model: String)

class Automobile(driver: String, model: String) {
  def unapply(g: Glass): Some[(Int, String)] = Some((g.id, g.model))
}


class Employee(
                val firstName: String,
                val middleName: Option[String],
                val lastName: String)

object Employee {
  //factory methods, extractors, apply
  //Extractor: Create tokens that represent your object
  def unapply(x: Employee) =
    Some((x.lastName, x.middleName, x.firstName))
}

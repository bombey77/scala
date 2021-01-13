package infix_types

object Demo1 {

  def main(args: Array[String]): Unit = {
    val romeo = Person1("Romeo")
    val juliet = Person1("Juliet")

    println(announceCouple(romeo loves juliet)) // Romeo is in love with Juliet
  }

  def announceCouple(person: Person1 Loves1 Person1) = {
    person.a.name + " is in love with " + person.b.name
  }
}

case class Person1(name: String) {
  def loves(person: Person1) = new Loves1(this, person)
}
class Loves1[A, B](val a: A, val b: B)

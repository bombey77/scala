package infix_types

object Demo {

  def main(args: Array[String]): Unit = {
    val romeo = Person("Romeo")
    val juliet = Person("Juliet")

    println(announceCouple(new Loves(romeo, juliet))) // Romeo is in love with Juliet
  }

  def announceCouple(couple: Person Loves Person) = {
  //Notice our type: Person loves Person!
    couple.a.name + " is in love with " + couple.b.name
  }
}

case class Person(name: String)
class Loves[A, B](val a: A, val b: B)

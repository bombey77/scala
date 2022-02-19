package partial_function

object Demo2 extends App {

  val list = List(Person("Roman", 35), Person("Kathy", 12))
  val adult1 = list filter { p => p.age >= 18 }
  val adult2 = list filter { _.age >= 18 }
  val adult3 = list filter { case Person(_, age) => age >= 18 }
  val adult4 = list filter { case Person(_, age) if age > 0 => true } // if age >= 18 => Exception => Person(Kathy,12) (of class partial_function.Person)

  println(adult1)
  println(adult2)
  println(adult3)
  println(adult4)
}

case class Person(name: String, age: Int)

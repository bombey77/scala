package equals

object Demo {

  def main(args: Array[String]): Unit = {
    val p1 = new Person("Roman", 34)
    val p2 = new Person("Roman", 34)

    println(p1 == p2) // false
    println(p1 eq p2) // false
    println(p1 equals p2) // false

    val h1 = Human("Roman", 34)
    val h2 = Human("Roman", 34)

    println(h1 == h2) // true
    println(h1 eq h2) // false
    println(h1 equals h2) // true
  }

  class Person(name: String, age: Int)
  case class Human(name: String, age: Int)
}

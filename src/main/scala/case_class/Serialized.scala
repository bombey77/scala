package case_class

object Serialized {

  def main(args: Array[String]): Unit = {
    val human = new Human("Roman", 34)
    val person = new Person("Roman", 34)

    println(human.isInstanceOf[Serializable]) // false
    // Note!!! Case classes are Serializable
    println(person.isInstanceOf[Serializable]) // true
  }

  class Human(name: String, age: Int)
  case class Person(name: String, age: Int)
}

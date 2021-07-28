package default_parameters

// default parameters
class User(name: String = "Bob", age: Int = 18) {

  override def toString: String = {
    s"name = ${this.name}, age - ${this.age}"
  }
}

object App {

  def main(args: Array[String]): Unit = {
    println(new User()) // name = Bob, age - 18

    val user1 = new User("Daria")
    println(user1) // name = Daria, age - 18

    // compile exception without: age = 12
    // val user2 = new User(12)
    val user2 = new User(age = 12)
    println(user2) // name = Bob, age - 12

    // another parameter order
    val user3 = new User(age = 21, name = "Mariya")
    println(user3) // name - Mariya, age - 21
  }
}

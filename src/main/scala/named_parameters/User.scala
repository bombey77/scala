package named_parameters

// named parameters
class User(name: String, age: Int) {

  override def toString: String = {
    s"name = ${this.name}, age - ${this.age}"
  }
}

object App {

  def main(args: Array[String]): Unit = {

    val user1 = new User("Daria", 18)
    println(user1) // name = Daria, age - 18

    val user2 = new User(name = "Bob", age = 12)
    println(user2) // name = Bob, age - 12

    // another parameter order
    val user3 = new User(age = 21, name = "Mariya")
    println(user3) // name - Mariya, age - 21
  }
}

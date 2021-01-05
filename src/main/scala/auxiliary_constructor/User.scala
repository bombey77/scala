package auxiliary_constructor

case class User(name: String, age: Int) {
// in any auxiliary constructor you should call default constructor (e.g. this(_,_)
  def this() {
    this("Default name", 0)
  }

  def this(name: String) {
    this(name, 0)
  }

  def this(age: Int) {
    this("Default name", age)
  }
}

object Demo extends App {

  val user = new User()
  println(s"Name - ${user.name}, age - ${user.age}") // Name - Default name, age - 0
  val user1 = new User(34)
  println(s"Name - ${user1.name}, age - ${user1.age}") // Name - Default name, age - 34
  val user2 = new User("Roman")
  println(s"Name - ${user2.name}, age - ${user2.age}") // Name - Roman, age - 0
}

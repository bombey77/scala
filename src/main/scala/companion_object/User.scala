package companion_object

import `import`.Person

class User(name: String, age: Int) {

  override def toString: String = s"name - $name, age - $age"
}

object User {

  def apply(name: String, age: Int) = new Person(name, age)
}

object Demo extends App {

  println(new User("Roman", 34))
  println(User.apply("Roman", 34))

  // new can be omitted because method 'apply' is present (without it there will be the compile error)
  // method 'apply' can be omitted because it present in the companion object
  println(User("Roman", 34))
}

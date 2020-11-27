package `import`

class Person(val name: String, val age: Int)

object Demo3 {
  def printOnConsole(p: Person): Unit = {
    import p._  //import class person as static and now I can call the variables from the Person without new Person()
    println("name - " + name + ", age - " + age)
  }
}

package trait_example

object Demo {

  def main(args: Array[String]): Unit = {
    val driver = new Driver
    println(driver.isInstanceOf[Driver]) // true
    println(driver.isInstanceOf[Person]) // true
    println(driver.isInstanceOf[Any]) // true
    println(driver.isInstanceOf[AnyRef]) // true

    val obj = new A with B
    println(obj.aId + obj.bId) // 3
  }
}

trait Person {
  def isOld(age: Int): Boolean
}
trait Gender {
  def isMale: Boolean
}
//A class can only extend from one class or trait, any subsequent extension should use the keyword with
class Driver extends Person with Gender {
  override def isMale: Boolean = ???
  override def isOld(age: Int): Boolean = age < 60
}

trait B {
  def bId = 2
}

trait A { self: B =>
  def aId = 1
}

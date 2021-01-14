package parent_classes

object Demo {

  def main(args: Array[String]): Unit = {
    val pilot = new Pilot("Roman", "Moto", 777)
    println(pilot.firstName) // Roman
    println(pilot.lastName) // Moto

    //    A class that extends from another is polymorphic
    val soldier: Soldier = pilot
    println(soldier.firstName) // Roman
    println(soldier.lastName) // Moto

    //    An abstract class, as in Java, cannot be instantiated and only inherited
    //    if you uncomment this line, it will fail compilation
    //    val aviator = new Aviator

//    A class can be placed inside an abstract class just like in Java
    val flyBoy = new FlyBoy("Roman", "Moto")
    val catchExample = new flyBoy.Catch(777)
    println(catchExample.number) // 777
  }
}

//Class hierarchy is linear, a class can only extend from one parent class
class Soldier(val firstName: String, val lastName: String) {}

class Pilot(override val firstName: String, override val lastName: String, val squadron: Long)
  extends Soldier(firstName, lastName)

abstract class Aviator(val firstName: String, val lastName: String) {

  class Catch(val number: Long) {
    // nothing to do here.  Just observe that it compiles
  }
}
class FlyBoy(override val firstName: String, override val lastName: String) extends Aviator(firstName, lastName)


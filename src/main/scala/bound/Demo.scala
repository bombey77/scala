package bound

trait Animal { def fitness: Int }
trait Reptile extends Animal
trait Mammal extends Animal
trait Zebra extends Mammal { def countZebra: Int }
trait Giraffe extends Mammal

object Demo {
  def main(args: Array[String]): Unit = {
    val animal = new Animal {
      override def fitness: Int = 1
    }
    val reptile = new Reptile {
      override def fitness: Int = 2
    }
    val giraffe = new Giraffe {
      override def fitness: Int = 3
    }

    val up: BoxUp[Animal] = new BoxUp[Giraffe]
    val low: BoxLow[Giraffe] = new BoxLow[Animal]
    println(up)
    println(low)
    println(up.set(giraffe))
    println(low.set(giraffe))
  }
//  Upper Bounds
//  A <: B means: A is a subtype of B, and
//  A >: B means: A is a supertype of B, or B is a subtype of A
  def upper[A <: Animal](a: A, b: A): Boolean = {
    a.fitness < b.fitness
  }
}

class BoxUp[+T] {
  def set[S >: T](s: S): S = {
    s
  }
}
class BoxLow[-T] {
  def set[S <: T](s: S): S = {
    s
  }
}

//Typing Rules for Functions
//If A2 <: A1 and B1 <: B2, then
//A1 => B1 <: A2 => B2
//So functions are contravariant in their argument type(s) and covariant in their result type.
//This leads to the following revised definition of the Function1 trait:

//trait Function1[-T, +U] {
//  def apply(x: T): U
//}
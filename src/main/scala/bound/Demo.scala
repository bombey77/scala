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
    println(upper(animal, giraffe))
    println(upper(animal, reptile))
  }
//  Upper Bounds
//  A <: B means: A is a subtype of B, and
//  A >: B means: A is a supertype of B, or B is a subtype of A
  def upper[A <: Animal](a: A, b: A): Boolean = {
    a.fitness < b.fitness
  }
}
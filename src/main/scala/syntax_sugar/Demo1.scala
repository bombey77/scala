package syntax_sugar

object Demo1 extends App {

  val c = new C
  c.x = 1 // write...
  c.x = (1) // write...
  println(c.x) // read...
//  OUTPUT
//  write...
//  write...
//  read...
//  0
}

class C {
  def x_=(x: Int): Unit = println("write...")
  def x: Int = {
    println("read...");0
  }
}

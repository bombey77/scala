package syntax_sugar

// As you can see I can read and write with methods like in variable
object Demo1 extends App {

  val c = new C
  c.x = 1 // write...
  c.x = (1) // write...
  println(c.x) // read...
//  OUTPUT
//  write...
//  write...
//  read...
//  1
}

class C {
  // variable
  private var tmp: Int = _

  // write with this method
  def x_=(x: Int): Unit = {
    tmp = x
    println("write...")
  }

  // read with this method
  def x: Int = {
    println("read...");tmp
  }
}

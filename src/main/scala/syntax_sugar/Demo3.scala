package syntax_sugar

object Demo3 extends App {
  // If method has name 'apply' you can call it like
  val d = new D3
  d(7) // x = 7
  d(8,3) // x = 8, y = 3
  d(9,true) // x = 9, b = true
}

class D3 {

  def apply(x: Int) = println(s"x = $x")
  def apply(x: Int, y: Int) = println(s"x = $x, y = $y")
  def apply(x: Int, b: Boolean) = println(s"x = $x, b = $b")
}

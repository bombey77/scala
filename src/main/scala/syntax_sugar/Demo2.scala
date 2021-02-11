package syntax_sugar

object Demo2 extends App {

  val d = new D2
  d() = 12 // 12
  d.update(12) // 12

  d() = true // true
  d.update(true) // true

  d(true) = 15 // b = true, x = 15
  d.update(true, 15) // b = true, x = 15

  d("A", false) = 16 // s = A, b = false, x = 16
  d.update("A", false, 16) // s = A, b = false, x = 16
}

class D2 {

  def update(x: Int): Unit = println(x)
  def update(b: Boolean): Unit = println(b)
  def update(b: Boolean, x: Int): Unit = println(s"b = $b, x = $x")
  def update(s: String, b: Boolean, x: Int): Unit = println(s"s = $s, b = $b, x = $x")
}


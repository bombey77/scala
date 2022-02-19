package carrying

object Demo extends App {

  // Currying is the technique of transforming a function
  // that takes multiple arguments into a function
  // that takes a single argument

  // def variant_1(x: Int): Int => Int = (y: Int) => x * y
  def variant_1(x: Int) = (y: Int) => x * y // short version

  val a1 = variant_1(10)
  val a2 = a1(2)
  println(a2) // 20

  //  def variant_2(x: Int)(y: Int): Int = x * y
  def variant_2(x: Int)(y: Int) = x * y // short version

  val b1 = variant_2(10) _
  val b2 = b1(2)
  println(b2) // 20

  val variant_3 = (x: Int) => (y: Int) => x * y
  val c1 = variant_3(10)
  println(c1(2)) // 20
}

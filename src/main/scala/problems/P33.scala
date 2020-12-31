package problems

// P33 (*) Determine whether two positive integer numbers are coprime.
//     Two numbers are coprime if their greatest common divisor equals 1.
//
//     scala> 35.isCoprimeTo(64)
//     res0: Boolean = true
object P33 {

  import P32._

  def isCoprimeTo(x: Int, y: Int): Boolean = gcd(x, y) == 1

  def main(args: Array[String]): Unit = {
    println(isCoprimeTo(35, 64)) // true because => 1
    println(isCoprimeTo(36, 63)) // false because => 9
  }
}

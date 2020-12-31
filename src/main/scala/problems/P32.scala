package problems

// P32 (**) Determine the greatest common divisor of two positive integer
//          numbers.
//     Use Euclid's algorithm.
//
//     scala> gcd(36, 63)
//     res0: Int = 9
object P32 {

  def gcd(m: Int, n: Int): Int = if (n == 0) m else gcd(n, m % n)

  def main(args: Array[String]): Unit = {
    println(gcd(36, 63))
  }
}

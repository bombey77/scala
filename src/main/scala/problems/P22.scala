package problems

// P22 (*) Create a list containing all integers within a given range.
//     Example:
//     scala> range(4, 9)
//     res0: List[Int] = List(4, 5, 6, 7, 8, 9)
object P22 {

  def main(args: Array[String]): Unit = {
    println(range(4, 9))
    println(rangeRecursive(4, 9))
    println(rangeTailRecursive(4, 9))
    println(rangeFunctional(4, 9))
  }

  def range(start: Int, end: Int): List[Int] = List.range(start, end + 1)

  //  Recursive
  def rangeRecursive(start: Int, end: Int): List[Int] = {
    if (start > end) Nil
    else start :: rangeRecursive(start + 1, end)
  }

  //  Tail recursive
  def rangeTailRecursive(start: Int, end: Int): List[Int] = {
    def range(end: Int, result: List[Int]): List[Int] = {
      if (end < start) result
      else range(end - 1, end :: result)
    }
    range(end, Nil)
  }

  // The classic functional approach would be to use `unfoldr`, which Scala
  // doesn't have.  So we'll write one and then use it.
  def unfoldRight[A, B](s: B)(f: B => Option[(A, B)]): List[A] =
    f(s) match {
      case None => Nil
      case Some((r, n)) => r :: unfoldRight(n)(f)
    }

  def rangeFunctional(start: Int, end: Int): List[Int] =
    unfoldRight(start) { n =>
      if (n > end) None
      else Some((n, n + 1))
    }
}
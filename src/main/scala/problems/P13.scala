package problems

// P13 (**) Run-length encoding of a list (direct solution).
//     Implement the so-called run-length encoding data compression method
//     directly.  I.e. don't use other methods you've written (like P09's
//     pack); do all the work directly.
//
//     Example:
//     scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
object P13 {

  def encodeDirect[A](l: List[A]): List[(Int, A)] = {
    if (l.isEmpty) Nil // returns an empty List()
    else {
      val (packed, tail) = l span { _ == l.head }
      // packed = List(Symbol(a), Symbol(a), Symbol(a), Symbol(a))
      // tail = List(Symbol(b), Symbol(c), Symbol(c), Symbol(a), Symbol(a), Symbol(d), Symbol(e), Symbol(e), Symbol(e), Symbol(e))
      (packed.length, packed.head) :: encodeDirect(tail)
    }
  }

  def main(args: Array[String]): Unit = {
    println(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}

package problems

// P17 (*) Split a list into two parts.
//     The length of the first part is given.  Use a Tuple for your result.
//
//     Example:
//     scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
object P17 {

  // Builtin.
  def split[A](n: Int, ls: List[A]): (List[A], List[A]) = {
    ls.splitAt(n)
  }

  // Functional (barely not "builtin").
  def splitFunctional[A](n: Int, ls: List[A]): (List[A], List[A]) = {
    (ls.take(n), ls.drop(n))
  }

  // Simple recursion.
  def splitRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) = (n, ls) match {
    case (_, Nil) => (Nil, Nil)
    case (0, ls) => (Nil, ls)
    case (n, h :: tail) => {
      val (pre, post) = splitRecursive(n - 1, tail)
      (h :: pre, post)
    }
  }

  // Tail recursive.
  def splitTailRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) = {
    def split(index: Int, list: List[A], res: List[A]): ((List[A], List[A])) = (index, list) match {
      case (_, Nil) => (Nil, Nil)
      case (0, list) => (res.reverse, list)
      case (x, h :: tail) => {
        split(x - 1, tail, h :: res)
      }
    }

    split(n, ls, Nil)
  }

  def main(args: Array[String]): Unit = {
    println(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitFunctional(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitTailRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
}

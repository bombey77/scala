package problems

// P15 (**) Duplicate the elements of a list a given number of times.
//     Example:
//     scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
//     res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
object P15 {

  def duplicate[A](n: Int, ls: List[A]): List[A] = {
    var list: List[A] = Nil
    ls foreach { e => for (i <- 1 to n) list = list :+ e }
    list
  }

  def main(args: Array[String]): Unit = {
    println(duplicate(3, List('a, 'b, 'c, 'c, 'd)))
  }
}

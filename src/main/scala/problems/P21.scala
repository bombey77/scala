package problems

// P21 (*) Insert an element at a given position into a list.
//     Example:
//     scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//     res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
object P21 {

  def main(args: Array[String]): Unit = {
    println(insertAt('new, 1, List('a, 'b, 'c, 'd)))
    println(insertAt1('new, 1, List('a, 'b, 'c, 'd)))
  }

  def insertAt[A](x: A, n: Int, ls: List[A]): List[A] = {
    val list = ls.splitAt(n)
    list._1 ::: List(x) ::: list._2
  }

  def insertAt1[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match {
    case (pre, post) => pre ::: e :: post
  }
}

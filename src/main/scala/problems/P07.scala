package problems

// P07 (**) Flatten a nested list structure.
//     Example:
//     scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//     res0: List[Any] = List(1, 1, 2, 3, 5, 8)
object P07 {

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case l: List[_] => flatten(l)
    case e => List(e)
  }

  def main(args: Array[String]): Unit = {
    println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  }
}

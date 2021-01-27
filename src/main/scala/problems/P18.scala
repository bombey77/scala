package problems

// P18 (**) Extract a slice from a list.
//     Given two indices, I and K, the slice is the list containing the elements
//     from and including the Ith element up to but not including the Kth
//     element of the original list.  Start counting the elements with 0.
//
//     Example:
//     scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('d, 'e, 'f, 'g)
object P18 {

  def main(args: Array[String]): Unit = {
    val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    println(dropFunctional(3, 7, ls))
    println(sliceFunctional(3, 7, ls))
    println(sliceFunctional1(3, 7, ls))
    println(sliceFunctional2(3, 7, ls))
    println(sliceRecursive(3, 7, ls))
    println(sliceTailRecursive(3, 7, ls))
    println(sliceTailRecursive2(3, 7, ls))
  }

  // Functional.
  def dropFunctional[A](start: Int, end: Int, ls: List[A]): List[A] = ls dropRight(ls.size - end) drop(start)
  // Functional.
  def sliceFunctional[A](start: Int, end: Int, ls: List[A]): List[A] = ls drop start take (end - (start max 0))
  // Functional.
  def sliceFunctional1[A](start: Int, end: Int, ls: List[A]): List[A] = ls.slice(start, start + (end - (start max 0)))
  // Functional.
  def sliceFunctional2[A](start: Int, end: Int, ls: List[A]): List[A] = ls.slice(start, end)

  // Simple recursive.
  def sliceRecursive[A](start: Int, end: Int, ls: List[A]): List[A] =
    (start, end, ls) match {
      case (_, _, Nil)                 => Nil
      case (_, e, _)         if e <= 0 => Nil
      case (s, e, h :: tail) if s <= 0 => h :: sliceRecursive(0, e - 1, tail)
      case (s, e, h :: tail)           => sliceRecursive(s - 1, e - 1, tail)
    }

  // Tail recursive, using pattern matching.
  def sliceTailRecursive[A](start: Int, end: Int, ls: List[A]): List[A] = {
    def sliceR(count: Int, curList: List[A], result: List[A]): List[A] =
      (count, curList) match {
        case (_, Nil)                     => result.reverse
        case (c, h :: tail) if end <= c   => result.reverse
        case (c, h :: tail) if start <= c => sliceR(c + 1, tail, h :: result)
        case (c, _ :: tail)               => sliceR(c + 1, tail, result)
      }
    sliceR(0, ls, Nil)
  }

  // Since several of the patterns are similar, we can condense the tail recursive
  // solution a little.
  def sliceTailRecursive2[A](start: Int, end: Int, ls: List[A]): List[A] = {
    def sliceR(count: Int, curList: List[A], result: List[A]): List[A] = {
      if (curList.isEmpty || count >= end) result.reverse
      else sliceR(count + 1, curList.tail,
        if (count >= start) curList.head :: result
        else result)
    }
    sliceR(0, ls, Nil)
  }
}

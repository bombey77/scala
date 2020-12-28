package problems

object P03 {

  def nthBuiltin[A](n: Int, ls:List[A]): A = {
    if (n >= ls.length) throw new NoSuchElementException
    else ls(n)
  }

  def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, h :: _   ) => h
    case (n, _ :: tail) => nthRecursive(n - 1, tail)
    case (_, Nil      ) => throw new NoSuchElementException
  }

  def main(args: Array[String]): Unit = {
    println(nthBuiltin(0, List(1, 2, 3, 4, 5)))//1
    println(nthRecursive(1, List(1, 2, 3, 4, 5)))//2
  }
}

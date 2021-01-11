package list

object Demo {

  def main(args: Array[String]): Unit = {
    val a = List(1, 2, 3)
    val b = List(1, 2, 3)

    println(s"a eq b => ${a eq b}") // false
    println(s"a equals b => ${a equals b}") // true
    println(s"a == b => ${a == b}") // true

    val x = Nil
    val y = Nil
    println(s"x eq Nil => ${x eq Nil}") // true
    println(s"x == Nil => ${x == Nil}") // true
    println(s"b eq Nil => ${b eq Nil}") // true
    println(s"b == Nil => ${b == Nil}") // true
    println(s"x eq y => ${x eq y}") // true
    println(s"x equals y => ${x equals y}") // true
    println(s"x == y => ${x == y}") // true

    println(a.headOption) // Some(1)
    println(a.head) // 1

    val filtered = a.filterNot(i => i == 2)
    println(filtered) // List(1, 3)
    a filterNot (i => i == 3) // Functions over lists can use () instead of {}
    val reduceLeft = a reduceLeft (_ + _)
    println(reduceLeft) // 6
    val reduceRight = a reduceRight(_ * _)
    println(reduceRight) // 6
    val foldLeft = a.foldLeft(4)(_ + _) // 4 + (1 + 2 + 3)
    println(foldLeft) // 10

    val p1 = List(1, 2)
    val p2 = List(3, 4)
    println(p1 ::: p2) // List(1, 2, 3, 4)
    println(p1 ::: Nil) // List(1, 2)

    val d1 = Nil
    val c1 = 3 :: d1
    val b1 = 2 :: c1
    val a1 = 1 :: b1
    println(a1) // List(1, 2, 3)
    println(a1.tail) // List(2, 3)
    println(b1.tail) // List(3)
    println(c1.tail) // List()
  }
}

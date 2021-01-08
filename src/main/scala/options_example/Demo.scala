package options_example

object Demo {

  def main(args: Array[String]): Unit = {
    val ar = Array(1, 3, 5, 7, 9)
    println(ar.find(_ == 3)) // Some(3)
    println(ar.find(_ > 10)) // None
    println(ar.find(_ == 20).getOrElse(0)) // 0

    val map = Map(1 -> "one", 2 -> "two", 3 -> "three")
    println(map.get(4)) // None

    val x: Option[Int] = Some(1)
    val y: Option[Int] = None
    println(x) // Some(1)
    println(y) // None
    println(x.fold(777)(_ + 2)) // 3 -> returns 1 + 2
    println(y.fold(777)(_ + 2)) // 777 -> returns default value (777) if y is None
  }
}

package type_constructors

object Demo {

  def main(args: Array[String]): Unit = {
//    val x0: ab[Int, String] = ???
//    val x1: Int ab String = ???

//    val y0: ++[Int, String] = ???
//    val y1: Int ++ String = ???

//    val z = List[Int ++ String]
//    class X extends (Int ++ String)
//    val r: Int ++ String => Int ++ String = ???

//    val u: Int ++ String ** Boolean = ???
  }
}

//ab, ++ type constructors
//(type constructor ab) + (type A) + (type B) => type ab[A, B] = type A ab B
//(type constructor ++) + (type A) + (type B) => type ++[A,B] = type A ++ B
class ab[A,B](a: A, b: B)
class ++[A,B](a: A, b: B)
class **[A,B](a: A, b: B)

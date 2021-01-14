package byname_parameter

object Demo {

  def main(args: Array[String]): Unit = {
    //    () => Int is a Function type that takes a Unit type. Unit is known as void to a Java programmer.
    //    The function returns an Int. You can place this as a method parameter so that you can you use it
    //    as a block, but still it doesn't look quite right

    val y = calc { () => // explicitly declaring that Unit is a parameter with ()
      14 + 15
    }
    println(y) // Right(29)

    //    A by-name parameter does the same thing as the previous koan but there is no need to
    //    explicitly handle Unit or (). This is used extensively in Scala to create blocks
    val x = calc2 {
      // This looks like a natural block
      println("Here we go!") // Some superfluous call
      val z = List(1, 2, 3, 4) // Another superfluous call
      49 + 20
    }
    println(x) // Right(69)
    println(calc2(12)) // Right(12)
  }

  def calc(x: () => Int): Either[Throwable, Int] = {
    try Right(x()) // An explicit call of the x function
    catch {
      case b: Throwable => Left(b)
    }
  }

  def calc2(x: => Int): Either[Throwable, Int] = {
    // x is a call by-name parameter
    try Right(x)
    catch {
      case b: Throwable => Left(b)
    }
  }
}

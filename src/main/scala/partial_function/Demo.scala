package partial_function

object Demo {

  def main(args: Array[String]): Unit = {
    //    A partial function is a trait that when implemented can be used as building blocks to determine a solution.
    //    The trait PartialFunction requires that the method isDefinedAt and apply be implemented:
    def doubleValue: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
      override def isDefinedAt(x: Int): Boolean = {
        x % 2 == 0
      }
      override def apply(v1: Int): Int = {
        v1 * 2
      }
    }

    println(doubleValue(4)) // 8

    //    Case statements are a quick way to create partial functions. When you create a case statement,
    //    the apply and isDefinedAt methods are created automatically.
    def doubledValue: PartialFunction[Int, Int] = {
      case x if (x % 2) == 0 => x * 2
    }

    println(doubledValue(4)) // 8

    //    The result of partial functions can have an andThen function added to the end of the chain:
    def addFive = (x: Int) => x + 5

    val doubled = doubledValue andThen addFive
    println(doubled(4)) // 13

    //    andThen can be used to continue onto another chain of logic:
    def printEven: PartialFunction[Int, String] = {
      case x if (x % 2) == 0 => "Even"
    }

    def printOdd: PartialFunction[Int, String] = {
      case x if (x % 2) != 0 => "Odd"
    }
    val doubledAndThen = doubledValue andThen (printEven orElse printOdd)
    println(doubledAndThen(4)) // Even => (4 * 2) % 2 = 0
  }
}

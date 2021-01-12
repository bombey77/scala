package partially_applied_functions

object Demo {

  def main(args: Array[String]): Unit = {
    def sum(a: Int, b: Int, c: Int): Int = a + b + c

    val res = sum _
    println(res(10, 2, 5)) // 17

    //    Partially applied functions can replace any number of arguments:
    val resC = sum(10, 2, _: Int)
    println(resC(8)) // 20

    def multiply(x: Int, y: Int): Int = x * y
    println((multiply _).isInstanceOf[Function2[_, _, _]]) // true

    val multiplyCurried = (multiply _).curried
    println(multiplyCurried(3)(2)) // 6
    val multiplyCurriedFour = multiplyCurried(4)
    println(multiplyCurriedFour(2)) // 8
    println(multiplyCurriedFour(5)) // 20

    //    Currying allows you to create specialized versions of generalized functions:
    def onlyEven(x: Int => Boolean)(xs: List[Int]): List[Int] = xs filter x
    def filterEven(x: Int): Boolean = x % 2 == 0
    val filtered = onlyEven(filterEven) _
    val list = filtered(List(1, 2, 3, 4, 5))
    println(list) // List(2, 4)
  }
}

package higher_order_function

// Функции высшего порядка
object HigherOrderFunction {

  def isMiddleValue: Int => Int => Int => Boolean = min => max => x => x > min && x < max

  def isBetween: Int => Boolean = isMiddleValue(0)(100)

  def isMiddleValue1(min: Int, max: Int): Int => Boolean = k => min < k && k < max

  def isBetween1: Int => Boolean = isMiddleValue1(0, 100)

  def main(args: Array[String]): Unit = {
    println(isBetween(10)) // true
    println(isBetween1(10)) // true
  }
}

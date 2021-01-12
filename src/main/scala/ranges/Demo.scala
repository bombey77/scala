package ranges

object Demo {

  def main(args: Array[String]): Unit = {
    val range = Range(0, 10)
    val second = range(1)
    val last = range.last

    println(second) // 1
    println(last) // 9
    println(range.size) // 10

//    Ranges can be specified using 'until':
    val untilRange = 0 until 10
    println(range == untilRange) // true

//    Range can specify a step for an increment:
    val stepRange = Range(0, 10, 3) // 3 is a range
    val secondStepRange = stepRange(1)
    val lastStepRange = stepRange.last
    println(secondStepRange) // 3
    println(lastStepRange) // 9

//    A range does not include its upper bound, even in a step increment:
    val r = Range(0, 10, 2)
    println(r.contains(10)) // false

//    Range can specify to include its upper bound value:
    val inclusiveRange = Range(0, 10).inclusive
    println(inclusiveRange.contains(10)) // true

//    Inclusive range can be specified by using 'to'
    val inclRange = Range(0, 10).inclusive
    val toRange = 0 to 10
    println(inclRange == toRange) // true
  }
}

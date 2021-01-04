package call_by_name_vs_call_by_value

object Demo {

  def callByValue(i: Int) = {
    println("Print int value - " + i)
    println("Print int value - " + i)
    println("Print int value - " + i)
  }

  def callByName(i: => Int) = {
    println("Print int value - " + i)
    println("Print int value - " + i)
    println("Print int value - " + i)
  }

  def main(args: Array[String]): Unit = {
    var amount = 0
    callByValue { amount += 1; amount }
//    Print int value - 1
//    Print int value - 1
//    Print int value - 1

    callByName { amount += 1; amount }
//    Print int value - 2
//    Print int value - 3
//    Print int value - 4
  }
}

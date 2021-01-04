package val_vs_def

object Demo {

  // The right hand side of a def definition is evaluated on each use.
  def sum(x: Int, y: Int): Int = {
    println(x + y)
    x + y
  }

  // The right hand side of a val definition is evaluated at the point of the definition itself.
  // Afterwards, the name refers to the value.
  val tmp = sum(3, 4)

  def main(args: Array[String]): Unit = {
    // result -> print -> 7
  }
}

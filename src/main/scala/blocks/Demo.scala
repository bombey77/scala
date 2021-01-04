package blocks

object Demo {

  {
    var t: Int = 10
    println(t)
    t = 123
    println(t)
  }

  val x = 0
  def f(y: Int) = y + 1
  val result = {
    val x = f(3)
    x * x
  } + x

  def main(args: Array[String]): Unit = {
//  OUTPUT
//  10
//  123
    println(result) // 16
    println(x) // 0

//    compile error -> The definitions inside a block are only visible from within the block.
//    println(t)
  }
}

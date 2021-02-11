package syntax_sugar

object Demo4 extends App {

  // this is the same function as function from D4 -> myFunction
  val myFunction = (x: Int) => x + 1
  println(myFunction(6)) // 7

  val d = new D4
  println(d.myFunction(6)) // 7
  println(d.myFunction.apply(6)) // 7
}

class D4 {

  val myFunction = new Function[Int, Int] {
    override def apply(x: Int): Int = {
      x + 1
    }
  }
}

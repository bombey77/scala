package associativity

object Demo {

  def main(args: Array[String]): Unit = {
    //I(4).*:I(3).++I(2) -> function *: is right-associative
    println(I(2) ++ I(3) *: I(4)) //I(14)

    //I(2).**:I(5).+:I(5) -> even if function +: is right-associative
    //function ** starts first because it's name starts with *
    println(I(2) ** I(5) +: I(5)) //I(15)

    //if functions are written as infix form and have the same priority (for example ++ and +:)
    //but they have different associativity (in this case left and right) they won't compile
    //    println(I(2) ++ I(5) +: I(5))//compile error
    //    println(I(2) ** I(5) *: I(5))//compile error
  }
}

case class I(x: Int) {
  def ++(that: I): I = I(that.x + x)

  def +:(that: I): I = I(that.x + x)

  def **(that: I): I = I(that.x * x)

  def *:(that: I): I = I(that.x * x)
}

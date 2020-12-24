package operator_precedence

object Demo {

  def main(args: Array[String]): Unit = {
    println(I(3) add I(2) mul I(4))//left-associative -> result I(20)
    println(I(3).add(I(2)).mul(I(4)))//left-associative -> result I(20)
    println(I(3) add (I(2) mul I(4)))//add extra columns to make it works correct -> result I(11)

    //in scala if you call method with a dot(not pointless style) it has a priority between pointless style
    //Don't use this style
    println(I(3) add(I(2)).mul(I(4)))// result I(11)

//    (characters not shown below)
//    * / %
//    + -
//    :
//    = !
//    < >
//    &
//    ^
//    |
//    (all letters)

    println(I(3) + I(2) * I(4))// it uses the priority shown above (first * and than + -> result I(20)
  }
}

case class I(x: Int) {
  
  def add(that: I):I = I(that.x + x)
  def mul(that: I):I = I(that.x * x)

  def +(that: I): I = I(that.x + x)
  def *(that: I):I = I(that.x * x)
}


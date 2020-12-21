package operators
import  scala.language.postfixOps

class Intro {
  //NOTE!!! Scala does not have any operators!!!

  // ++1 prefix operator
  // 1 + 1 infix operator
  // 1++ postfix operator

  //prefix
  val p0 = ~0 //Int bitwise negation
  val p1 = 0.unary_~ //line 9 is the same as line 10

  //infix
  val i0 = 1 + 1 //Int addition
  val i1 = 1.+(1) //line 14 is the same as line 15

  //postfix
  val s0 = 1 toByte //Int -> Byte conversion
  val s1 = 1.toByte
}

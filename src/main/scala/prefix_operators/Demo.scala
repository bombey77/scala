package prefix_operators

object Demo {
//  The only identifiers that can be used as prefix operators are +, -, !, and ~:
  def main(args: Array[String]): Unit = {
    val x0 = +I(0)
    val x1 = -I(0)
    val x2 = ~I(0)
    val x3 = !I(0)

    val y0 = I(0).unary_+()
    val y1 = I(0).unary_-()
    val y2 = I(0).unary_~()
    val y3 = I(0).unary_!()

    val stereo = new Stereo
    println(+stereo)
    println(-stereo)
  }
}

case class I(x: Int) {

  def unary_+(): I = I(2 + x)

  def unary_-(): I = I(2 + x)

  def unary_~(): I = I(2 + x)

  def unary_!(): I = I(2 + x)
}

class Stereo {
  def unary_+ = "on"

  def unary_- = "off"
}
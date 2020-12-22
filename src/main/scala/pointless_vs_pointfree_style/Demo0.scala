package pointless_vs_pointfree_style

object Demo0 {

  def main(args: Array[String]): Unit = {
    //Not point-free style (x is present), not pointless style
    def a: Int => Int = x => 1.+(x)
    //Not point-free style, pointless style
    def b: Int => Int = x => 1 + x
    //point-free style, pointless style with placeholder
    def c: Int => Int = 1 + _
    //point-free style, pointless style
    def d: Int => Int = 1 +
  }
}

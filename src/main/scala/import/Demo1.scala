import java.lang.Integer.valueOf  //import static method
import java.lang.Float._  //import whole class as static
import java.lang.Double.{isInfinite => isInf} //import with rename method isInfinite as isInf

object Demo1 {

  def main(args: Array[String]): Unit = {
    val staticMethod = valueOf("33")
    val isInfinit = isInf(12)
    val fl = floatToRawIntBits(0.1f)
  }
}

package byname_parameter

object Demo1 {

  def main(args: Array[String]): Unit = {
    val result = PigLatinizer {
      val x = "pret"
      val z = "zel"
      x ++ z //concatenate the strings
    }
    println(result) // retzelpay
  }
}

object PigLatinizer {
  def apply(x: => String) = x.tail + x.head + "ay"
}


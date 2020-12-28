package match_example

object MatchExample {

  def verify(x: Any): String = x match {
    case i: Int => "This is Int " + x
    case s: String => "This is string - ".toUpperCase() + x
  }

  def main(args: Array[String]): Unit = {
    println(verify(12)) //This is Int 12
    println(verify("text")) //THIS IS STRING - text
  }
}

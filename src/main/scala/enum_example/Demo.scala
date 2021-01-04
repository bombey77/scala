package enum_example

object Demo {

  def main(args: Array[String]): Unit = {
    println(getColor(Red)) // Red color
    println(getColor(Yellow)) // Yellow color
    println(getColor(Green)) // Green color
  }

  def getColor(color: Color): String = color match {
    case Red => "Red color"
    case Yellow => "Yellow color"
    case Green => "Green color"
  }
}

sealed trait Color
case object Red extends Color
case object Yellow extends Color
case object Green extends Color


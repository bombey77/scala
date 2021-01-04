package match_example

object MatchExample {

  def verify(x: Any): String = x match {
    case i: Int => "This is Int " + x
    case s: String => "This is string - ".toUpperCase() + x
  }

  def verify1(obj: Any): AnyRef = obj match {
    case Person(age, name) => name
    case Gender(gender) => gender
  }

  def main(args: Array[String]): Unit = {
    println(verify(12)) //This is Int 12
    println(verify("text")) //THIS IS STRING - text

    println(verify1(Person(34, "Roman"))) // Roman
    println(verify1(Gender("Male"))) // Male
  }
}

case class Person(age: Int, name: String)
case class Gender(gender: String)

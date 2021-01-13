package match_example

object PatternMatching {

  def verify(x: AnyRef): String = x match {
    case CaseClass(name) => "Case classes are work with pattern matching"
//    case RegularClass(name) => compiler ERROR!!! => By default,
//    pattern matching does not work with regular classes.
  }

  def main(args: Array[String]): Unit = {
    println(verify(CaseClass("Roman"))) // "Case classes are work with pattern matching"

    val employee = Employee("Roman", "Moto")
    val res = employee match {
      case Employee("Roman", _) => "Good choice"
      case _ => "What did you bring here?"
    }
    println(res) // "Good choice"
  }
}

case class CaseClass(name: String)
class RegularClass(name: String)

// or another example
case class Employee(firstName: String, lastName: String)

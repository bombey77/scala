package match_example

object PatternMatching {

  def verify(x: AnyRef): String = x match {
    case CaseClass(name) => "Case classes are work with pattern matching"
//    case RegularClass(name) => compiler ERROR!!! => By default,
//    pattern matching does not work with regular classes.
  }
}

case class CaseClass(name: String)
class RegularClass(name: String)

package extensibility

object Demo {

  class RegularClass()
  case class CaseClass()
  class R extends RegularClass
  //case class T extends RegularClass => (COMPILE ERROR) a case class can not extend regular class
  //case class V extends CaseClass => (COMPILE ERROR) a case class can not extend another case class
  //(because it would not be possible to correctly implement their equality)
}

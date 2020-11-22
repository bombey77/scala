package type_definition

//trait T
//class C
object O

object TypeDefinition extends App {

  val t: T = null
  val c: C = null
  //  val o: type_definition.O = null -> ошибка компиляции
  val o: O.type = null

  def tFunc(t: T): T = ???
  def cFunc(c: C): C = ???
  //  def oFunc(o: type_definition.O): type_definition.O = ??? -> ошибка компиляции
  def oFunc(o: O.type): O.type = ???

  def caseFunc(arg: Any): String = arg match {
    case _: T => "type_definition.T"
    case _: C => "type_definition.C"
    //    case _:type_definition.O => "type_definition.O" -> ошибка компиляции
    case _: O.type => "type_definition.O"
  }
}



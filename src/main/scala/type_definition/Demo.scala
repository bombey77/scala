package type_definition

trait T
class C

//объявление объекта создает создает singleton
object OT extends T //можно наследоваться от trait
object CT extends C //можно наследоваться от класса

class Demo {

  def tFunc(t: T): Unit = ???

  tFunc(new T {}) //передаю trait и объявляю его
  tFunc(OT)

  def cFunc(c: C): Unit = ???

  cFunc(new C)
  cFunc(CT)

  def caseFunc(any: Any): String = any match {
    case _: T => "T"
    case _: C => "C"
//    case _: OT => "OT" -> ошибка компиляции
    case _: OT.type => "OT"
  }
}

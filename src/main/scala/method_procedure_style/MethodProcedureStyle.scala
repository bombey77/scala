package method_procedure_style

class MethodProcedureStyle {
// Three rules for procedure methods
//1. the equals sign are omitted
//2. the result sign is omitted
//3. method defining expression must be a block

//  def f0(x: Int): Int {} -> compile error
//  def f0(x: Int): Int 1 -> compile error
//    def f0(x: Int): 1 -> compile error
    def f0(x: Int) {1}// you should avoid procedure syntax because it return Unit and you may not think about it,
//  please find the example below (object Test)
    def f1(x: Int) {return 1} // even this method returns Util (word return does nothing)

//  Обрати внимание, что тут неявное преобразование. Unit является наследником объекта AnyVal
//  а в примере ниже AnyVal преобразовывается в Unit

//  AnyVal -> Unit
  def f2(): Unit = {1}
  def f3(): Unit = 1
  def f4(): Unit = {1}

//  AnyRef -> Unit
  def f5(): Unit = {"Unit"}
  def f6(): Unit = "Unit"
  def f7(): Unit = return "Unit"

  val any: Any = null
  def f8(): Unit = {any}
  def f9(): Unit = any
  def f10(): Unit = return any
}

object Test extends App {
  println(new MethodProcedureStyle().f0(10))// method print '()' because it returns Unit
  println(new MethodProcedureStyle().f1(10))// method print '()' because it returns Unit
}

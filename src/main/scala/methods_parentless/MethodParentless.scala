package methods_parentless

class MethodParentless {

  //  f0 == f1 -> true
  //  g0() == g1() -> true

  //  метод который без параметров может записываться без скобок
  def f0 = 1

  def f1: Int = 1

  def g0() = 1

  def g1(): Int = 1
}

object Test extends App {
  //  метод объявленный без круглых скобок, может быть вызван только без круглых скобок
  println(new MethodParentless().f0)
  //  println(new MethodParentless().f0()) -> ошибка компиляции

  //  метод объявленный с круглыми скобками, может быть вызван как с круглыми скобками так и без них
  println(new MethodParentless().g0())
  println(new MethodParentless().g1())

  //  Uniform Access Principle
  class A {
   def test = {
     val x = 12
     val y = 33 + x
     y
   }
  }
  println(new A().test)// выглядит как вызов переменной,
  // но на самом деле вызов функции test -> лучшу не использовать такой синтаксис

  //  метод f0 может быть вызван следующими способами
  (new MethodParentless).f0
  new MethodParentless().f0
  //  new MethodParentless.f0 -> ошибка компиляции
}

package methods_simplification

class MethodsSimplification {

  //  Scala method in Java style
  def f0(x: Int, y: Int): Int = {
    return x + y;
  }

  //  Semicolon inference
  def f1(x: Int, y: Int): Int = {
    return x + y
  }

  //  last expression return
  def f2(x: Int, y: Int): Int = {
    x + y
  }

  //  single expression return
  def f3(x: Int, y: Int): Int = x + y

  //  return type inference
  def f4(x: Int, y: Int) = x + y
  def f5(x: Byte, y: Byte): Int = x + y
  //  def f6(x, y): Int = x + y -> doesn't compile

  //  Public API - don't use type inference
  def f6(x: Int, y: Long) = x + y // it's confuse people, as you can see it returns Long

  //  params == val
  def f7(x: Int, y: Int) = x + y
//  def f8(var x: Int, val y: Int) = x + y -> doesn't compile (we can't write var or val with parameters)
  def f8(x: Int, y: Int) = {
//    x = x + y -> doesn't compile -> we can't change val
//    y = x + y -> doesn't compile -> we can't change val
    x + y
  }

  //  Nested function
  def f9(x: Int, y: Int) = {
    def sqr(x: Int, y: Int) = x * y
    sqr(x, y)
  }

  //  recursive def definition and return type reference
//  def f10(x: Int) = if (x == 0) 1 else x * f10(x - 1) -> doesn't compile
    def f10(x: Int): Int = if (x == 0) 1 else x * f10(x - 1)
}

//переменной функционального типа,
//присваивается функциональное значение
val sqr: Int => Int = (x: Int) => x * x
val add = (x: Int, y: Int) => x + y

sqr(5)
add(2, 3)

//Int => Int функциональный тип
sqr.isInstanceOf[Any]
sqr.isInstanceOf[AnyRef]

val sqr1 = new Function1[Int, Int] {
  override def apply(x:Int) = x * x
}
val add1 = new Function2[Int, Int, Int] {
  override def apply(x:Int, y:Int) = x + y
}
//тоже что и запись add1
val sqr2 = new (Int => Int) {
  override def apply(x: Int) = x * x
}

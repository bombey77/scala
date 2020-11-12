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
  override def apply(x: Int) = x * x
}
val add1 = new Function2[Int, Int, Int] {
  override def apply(x: Int, y: Int) = x + y
}
//тоже что и запись add1
val sqr2 = new (Int => Int) {
  override def apply(x: Int) = x * x
}

val sqr3: Int => Int = x => x * x
val add3: (Int, Int) => Int = (x, y) => x + y
val add4: (Int, Int) => Int = _ + _
val add5 = (_: Int) + (_: Int)

//при написании рекурсивных функций обязательно указывать функциональный тип
//val factorial = (n: Int) => if (n == 0) 1 else n * factorial(n - 1)
val factorial: Int => Int = n => if (n == 0) 1 else n * factorial(n - 1)

val addSqr: (Int, Int) => Int = {
  (x, y) =>
    val sqr1 = sqr(x)
    val sqr2 = sqr(y)
    add(sqr1, sqr2)
}
addSqr(2, 2)
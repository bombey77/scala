//обязан быть один val параметр
class MyInt(val value: Int) extends AnyVal {
  override def toString: String = s"MyInt($value)"

  def add(other: MyInt) = new MyInt(value + other.value)
  def multiply(other: MyInt) = new MyInt(value * other.value)
}

val a = new MyInt(10)
val b = new MyInt(20)

1 + 2
1.+ (2)

//в scala операторы - это обычные методы записанные в инфексной форме
//Инфексная форма - это отсутсвие точки перед названием метода и круглых скобок окружающих аргумент
//Работает два правила:
//1. Если явно задан аргумент, то метод можно вызвать без точки
//2. Если метод принимает только один аргумент, то круглые скобки можно опустить

//error
//a * b

//error тут используется конкатенация строк
//a + b

//инфексная форма вызова метода
Console println "Hi Roman"

a add b
1 + 2 * 3//7 -> 1 + (2 * 3)
a add b multiply b//(10 + 20) * 20 = 600 -> тут отработало первое сложение


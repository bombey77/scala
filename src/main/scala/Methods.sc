def max(x: Int, y: Int) = {
  if (x > y) x else y
}
println(max(5, 7)) //7

def add(x: Int, y: Int) = {
  //внутри функции можно объявлять другую функцию
  def sqr(q: Int) = q * q
  //результатом выполнения функции будет полследняя строка
  sqr(x) + sqr(y)
}
println(add(2, 2)) //8

def useReturn(x: Int): Int = {
  if (x > 10) 1
  //return желательно не использовать
  else return -1
  //если используется слово return,
  //то обязательно писать возвращаемое значение : Int
}
println(useReturn(10)) //-1

def func(x: Int): Unit = {
  //x = x + x -> ошибка т.к. параметр функции x является val
}


package any_example

object AboutAny {

  def main(args: Array[String]): Unit = {
    // you can put anything into Any
    var anyList: List[Any] = List("1", "2", "3")
    anyList = List(1, 2, 3)

    // если убрать знак + у класса MyList, то код не скомпилируется
    // знак + указывает, что MyList[String] потомок MyList[Any]
    var myList: MyList[Any] = new MyList[String]
    myList = new MyList[Integer]

    // ошибка компиляции т.к. нельзя создать инстанс абстрактного класса Any или AnyVal
//    val myAny = new Any
//    val myAnyVal = new AnyVal
    val myAnyRef = new AnyRef
  }
}

//Знак + это указание ковариантности
class MyList[+A]

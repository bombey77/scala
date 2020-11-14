class MyInt(val value: Int) extends AnyVal {

  def ++(other: MyInt) = new MyInt(value + other.value)
  def --(other: MyInt) = new MyInt(value - other.value)
  def **(other: MyInt) = new MyInt(value * other.value)

  override def toString: String = s"MyInt($value)"
}

object Order extends App {
  val a = new MyInt(20)
  val b = new MyInt(10)

//  left associative
  println(a ++ b ** b)//120
  println(a.++(b.**(b)))//120

  var list = 1 :: 2 :: 3 :: Nil
  println(list)//List(1, 2, 3)

  var originList = Nil.::(3).::(2).::(1)
  println(originList)//List(1, 2, 3)

  list = list :+ 4
  println(list)//List(1, 2, 3, 4)

//  right associative
  var rightAssociative = Nil.::(4).::(3).::(2).::(1)
  println(rightAssociative)//List(1, 2, 3, 4)

  list = 0 +: list
  println(list)//List(0, 1, 2, 3, 4)

  var right = Nil.::(1).::(0)
  println(right)
}
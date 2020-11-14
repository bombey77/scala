class MyInt(val value: Int) extends AnyVal {

  def +(other: MyInt) = new MyInt(value + other.value)
  def -(other: MyInt) = new MyInt(value - other.value)
  def *(other: MyInt) = new MyInt(value * other.value)

  override def toString: String = s"MyInt($value)"
}

val a = new MyInt(20)
val b = new MyInt(10)

//если метод имеет в названии спец символы, то он отрабатывает первым
a - b * b // -80 (a - (b * b))






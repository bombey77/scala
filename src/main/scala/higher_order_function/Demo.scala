package higher_order_function

object Demo {

  def main(args: Array[String]): Unit = {
    println(addWithoutSyntaxSugar(2)(4)) // 6
    println(addWithoutSyntaxSugar(2).isInstanceOf[Function1[Int,Int]]) // true
    println(tenAdded(4)) // 14
    println(addWithSyntaxSugar(2)(4)) // 6
    println(addWithSyntaxSugar(2).isInstanceOf[Function1[Int,Int]]) // true
    println(addWithSyntaxSugar(2).isInstanceOf[Function1[_,_]]) // true

    println(makeUpper(List("Roman", "Kathy"))) // List(ROMAN, KATHY)
    println(makeWhateverYouLike(List("Roman", "Kathy"), x => x.toLowerCase())) // List(roman, kathy)
    println(getLength(List("Kate", "Vasyl", "Erdogan"))) // List(4, 5, 7)
    println(makeWhateverYouLike(List("Roman", "Kathy"), myName)) // List(My name is Roman, My name is Kathy)
  }

  def tenAdded: Function[Int, Int] = addWithoutSyntaxSugar(10)

  def addWithoutSyntaxSugar(x: Int): Function[Int, Int] = {
    new Function[Int, Int]() {
      def apply(y: Int): Int = x + y
    }
  }

  def addWithSyntaxSugar(x: Int) = (y: Int) => x + y

  def makeUpper(ls: List[String]) = {
    ls map {
      _.toUpperCase
    }
  }

  def makeWhateverYouLike(ls: List[String], sideEffect: String => String) = {
    ls map sideEffect
  }

  def getLength(ls: List[String]) = ls map (_.length)

  val myName = (name: String) => s"My name is $name"
}

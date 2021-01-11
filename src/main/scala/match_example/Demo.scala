package match_example

object Demo {

  def main(args: Array[String]): Unit = {
    val color = "blue"
    val col = color match {
      case "red" =>
        println("red"); 1
      case "green" =>
        println("green"); 2
      case "blue" =>
        println("blue"); 3
      case _ =>
        println(color); 0
    }
    // it will print 'blue'
    println(col) // it will print '3'

    //    Pattern matching can return complex values:
    val birthdate = "12-10-1991"
    val date = birthdate match {
      case "10-10-1991" => (10, 10, 1991)
      case "12-10-1991" => (12, 10, 1991)
      case _ => (0, 0, 0)
    }
    println(date) // (12,10,1991)

    //    Pattern matching can match complex expressions:
    def complexExpr(x: Any): String = x match {
      case ("Roman", "Moto") => "Nice to see you, sir)))"
      case ("Kathy", "Moto") => "Nice to see you, madam)))"
      case _ => "Who are you???"
    }

    println(complexExpr(("Roman", "Moto"))) // "Nice to see you, sir)))"

    //    Pattern matching can wildcard parts of expressions:
    def wildCard(x: Any): String = x match {
      case ("Roman", _) => "Nice to see you, sir)))"
      case ("Kathy", "Moto") => "Nice to see you, madam)))"
      case _ => "Who are you???"
    }

    println(wildCard(("Roman", "Burger"))) // "Nice to see you, sir)))"

    //    Pattern matching can substitute parts of expressions:
    def substitude(expr: (String, String)): String = expr match {
      case ("Roman", surename) => s"Nice to see you, $surename"
      case (name, "Moto") => s"Nice to see you, $name"
      case _ => "Who are you???"
    }

    println(substitude(("Roman", "Moto"))) // Nice to see you, Moto

    //    A backquote can be used to refer to a stable variable in scope to create a case statement -
    //    this prevents "variable shadowing":
    val foodItem = "fish"

    def backquote(expr: (String, String)): String = expr match {
      case (`foodItem`, "sea") => "fish"
      case ("ocean", "dolphin") => "dolphin"
      case _ => "What kind are you???"
    }

    println(backquote(("fish", "sea"))) // fish
    println(backquote(("while", "ocean"))) // What kind are you???

    //    A backquote can be used to refer to a method parameter as a stable variable to create a case statement:
    def patternEquals(a: Int, b: Int): Boolean = b match {
      case `a` => true
      case _ => false
    }

    println(patternEquals(3, 3)) // true
    println(patternEquals(1, 3)) // false

    //    To pattern match against a List, the list can be split into parts, in this case the head x and the tail xs.
    //    Since the case doesn't terminate in Nil, xs is interpreted as the rest of the list:
    val secondElement = List(1, 2, 3) match {
      case x :: xs => xs.head
      case _ => 0
    }

    println(secondElement) // 2

    //    To obtain the second element you can expand on the pattern.
    //    Where x is the first element, y is the second element, and xs is the rest:
    val secondExtraElement = List(1, 2, 3, 4) match {
      case x :: y :: xs => y
      case _ => 0
    }
    println(secondExtraElement) // 2


    //  Same koan as above, but we are pattern matching a list with only one item!
    val oneItemList = List(1) match {
      case x :: y :: xs => y
      case _ => 0
    }
    println(oneItemList) // 0

    //  To pattern match against List, you can also establish a pattern match if you know the exact number of elements in a List:
    val r = List(1, 2, 3) match {
      case x :: y :: Nil => "two items list"
      case _ => 0
    }
    println(r) // 0

    //  If a pattern is exactly one element longer than a List, it extracts the final Nil:
    val n = List(1, 2, 3) match {
      case x :: y :: z :: tail => tail
      case _ => 0
    }
    println(n) // List() or Nil
  }
}

package formatting

object Demo {

  def main(args: Array[String]): Unit = {
//    String can be placed in format:
    val t = "Roman"
    println("Hi %s".format(t)) // Hi Roman

//    Character Literals can be a single character:
    val s = 'c'
    println("My symbol is %c".format(s)) // My symbol is c

//    Character Literals can be an escape sequence, including hexidecimal:
    val c = 'a' //unicode for a
    val e = '\"'
    val f = '\\'
    println("%c".format(c)) // a
    println("%c".format(e)) // "
    println("%c".format(f)) // \

//    Formatting can also include numbers:
    val j = 12
    println("we bought %d bottles of beer" format j - 5) // we bought 7 bottles of beer

//    Formatting can be used for any number of items, like a string and a number:
    val v = "vodka"
    val n = 3
    println("we decided to bring %d bottles of %s".format(n, v)) // we decided to bring 3 bottles of vodka
  }
}

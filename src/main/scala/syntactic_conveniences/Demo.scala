package syntactic_conveniences

object Demo {

  def main(args: Array[String]): Unit = {
    printString("Java") // Hello, Java!
    printStringComplexExpr("Java") // Hello, JAVA!

    repeatedParameters(1, 2, 3).foreach(x => println(x))
  }

  // To splice values into constant String at runtime, you can use string interpolation
  def printString(text: String) = println(s"Hello, $text!")

  // If you want to splice a complex expression (more than just an identifier), surround it with braces
  def printStringComplexExpr(text: String) = println(s"Hello, ${text.toUpperCase}!")

  // You can define a function that can receive an arbitrary
  // number of parameters (of the same type) as follows
  def repeatedParameters(i: Int*): Seq[Int] = i
}
package while_example

object Demo extends App {

  // while is EXPRESSION and it should always returns something
  // in this case while returns Unit (println in this case doesn't do anything)
  val res: Unit = while(true) println("some")

  // in Scala while works like in Java
}

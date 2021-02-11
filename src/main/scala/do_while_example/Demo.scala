package do_while_example

object Demo extends App {

  // do-while is EXPRESSION and it should always returns something
  // in this case do-while returns Unit (println in this case doesn't do anything)
  val res: Unit = do println("some") while (true)

  // in Scala do-while works like in Java
}

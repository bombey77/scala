package if_example

object Demo extends App {

  val res0: Int = if (System.currentTimeMillis() > 0) 1 else 0
  // return value can be Any or AnyVal (Integer extends Any(AnyVal) -> Unit '()' extends Any)
  val res1: Any = if (System.currentTimeMillis() < 0) 0
  // return value can be Any or Unit (String extends Any(AnyRef) -> Unit '()' extends Any)
  val res2: Any = if (System.currentTimeMillis() < 0) "some"
  // res3 is the same as re1
  val res3: Any = if (System.currentTimeMillis() < 0) 0 else ()
  // res4 is the same as re2
  val res4: Any = if (System.currentTimeMillis() < 0) "some" else ()

  println(res0) // 1
  println(res1) // ()
  println(res2) // ()
  println(res3) // ()
  println(res4) // ()
}

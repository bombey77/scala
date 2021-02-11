package for_example

object Demo1 extends App {
  // we can iterate over map
  val map = Map(1 -> "A", 2 -> "B", 3 -> "C")

  // we can get keys and values
  for ((key, value) <- map) println(s"key = $key, value = $value")
  //  key = 1, value = A
  //  key = 2, value = B
  //  key = 3, value = C

  // we can get only keys after calling method keys
  for (key <- map.keys) println(s"key = $key")
  //  key = 1
  //  key = 2
  //  key = 3

  // we can get only values after calling method values
  for (value <- map.values) println(s"value = $value")
  //  value = A
  //  value = B
  //  value = C
}

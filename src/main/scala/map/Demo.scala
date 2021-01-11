package map

object Demo {

  def main(args: Array[String]): Unit = {
    var map = Map("k" -> 1)
    val map1 = Map(("k", 1))
    println(map) // Map(k -> 1)
    println(map1) // Map(k -> 1)
    println(map.apply("k")) // 1
    println(map.get("k")) // Some(1)
    println(map.getOrElse("k", 123)) // 1
    println(map.getOrElse("abc", 123)) // 123
    println(map.contains("k")) // true
    println(map.isDefinedAt("k")) // true

    map += ("s" -> 12) // add
    println(map.apply("s")) // 12
//    Maps insertion with duplicate key updates previous entry with subsequent value
    map += ("s" -> 14) // update
    println(map.apply("s")) // 14
    map -= ("s") // remove
    println(map.get("s")) // None

//    Subcollection producers keys, keySet, keysIterator, values, valuesIterator,
//    which return a map's keys and values separately in various forms
    map += ("l" -> 21)
    for(key <- map.keys) print(key) // kl (Iterable)
    for(key <- map.keySet) print(key) // kl (Set)
    for(key <- map.keysIterator) print(key) // kl (Iterator)
    println(map.values) // Iterable(1, 21)
    for(key <- map.valuesIterator) print(key) // 1 21 (Iterator)

//    Transformations filterKeys and mapValues, which produce a new map
//    by filtering and transforming bindings of an existing map
//    println(map.filterKeys(i => i equals "k").foreach(x => println(x))) (k,1)
//    println(map.mapValues(i => i equals "k").foreach(x => println(x))) (l,false)
    val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")
    val mapValues = myMap.values
    println(mapValues.size) // 3
    println(mapValues.head) // Michigan -> The order in maps is not guaranteed

    // Maps may be accessed:
    println(myMap("MI")) // Michigan

//    Map keys may be of mixed type
    val mixMap = Map("Ann Arbor" -> "MI", 49931 -> "MI")
    mixMap("Ann Arbor") // MI
    mixMap(49931) // MI

    var excepMap = Map("a" -> 1, "b" -> 2, "c" -> 3)
//    println(excepMap("aa")) -> throw NoSuchElementException
    excepMap = excepMap.withDefaultValue(7)
    println(excepMap("abc")) // 7

    val gMap = Map("a" -> 1, "b" -> 2, "c" -> 3)
    println(gMap.getOrElse("abc", 33)) // 33

//    Map elements can be added in multiple
    var z1 = Map("a" -> 1, "b" -> 2)
    val z2 = Map("c" -> 3, "d" -> 4)
    z1 = z1 ++ z2
    println(z1) // Map(a -> 1, b -> 2, c -> 3, d -> 4)
//    Map elements can be deleted in multiply
    val deletedMap = z1 -- List("c", "d")
    println(deletedMap) // Map(a -> 1, b -> 2)

//    Attempted removal of nonexistent elements from a map is handled gracefully
    val beforeMap = Map("a" -> 1, "b" -> 2)
    val afterMap = beforeMap - "c"
    println(beforeMap.equals(afterMap)) // true

//    Map equivalency is independent of order
    val order1 = Map("a" -> 1, "b" -> 2)
    val order2 = Map("b" -> 2, "a" -> 1)
    println(order1 equals order2) // true
  }
}

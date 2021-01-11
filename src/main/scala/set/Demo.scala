package set

object Demo {

//  Note! Set is not ordered
  def main(args: Array[String]): Unit = {
    val a = Set(1, 2, 3, 4)
    println(a.contains(1)) // true
    println(a.apply(1)) // true (apply is the same as contains)
    println(Set(1, 2).subsetOf(a)) // true

//    Additions
    val b = Set(1, 2, 3, 4)
    val c = b + 5
    println(c) // HashSet(5, 1, 2, 3, 4)
    val d = c ++ Set(6, 7)
    println(d) // HashSet(5, 1, 6, 2, 7, 3, 4)

//    Removals
    val e = d - 7
    println(e) // HashSet(5, 1, 6, 2, 3, 4)
    val f = e -- Set(5, 6)
    println(f) // HashSet(1, 2, 3, 4)

//    Set operations
    println(f.intersect(Set(1, 2))) // HashSet(1, 2)
    println(f & Set(1, 2)) // HashSet(1, 2) (is the same as intersect)
    println(f.union(Set(1, 2, 5))) // HashSet(5, 1, 2, 3, 4)
    println(f | Set(1, 2, 5)) // HashSet(5, 1, 2, 3, 4) is the same as union
    println(f.diff(Set(1, 2))) // HashSet(3, 4)
    println(f &~ Set(1, 2)) // HashSet(3, 4) is the same as diff

//    Sets may be of mixed type
    val g = Set("a", "b", 4)

//    Sets can be checked for member existence
    println(g(4)) // true
  }
}

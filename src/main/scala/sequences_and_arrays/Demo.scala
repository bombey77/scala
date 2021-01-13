package sequences_and_arrays

object Demo {

  def main(args: Array[String]): Unit = {
    //    A list can be converted to an array:
    val l = List(1, 2, 3)
    val a = l.toArray
    println(a) // Array[1, 2, 3]

    //    Any sequence can be converted to a list:
    val z = Array(1, 2, 3)
    val s = z.toSeq
    val xs = s.toList
    println(xs) // List(1, 2, 3)

    //    You can create a sequence from a for loop:
    val seq = for (i <- 1 to 4) yield i
    println(seq.toList) // List(1, 2, 3, 4)

    //    You can create a sequence from a for loop with a filter:
    val filteredSeq = for (i <- 1 to 10 if i % 3 == 0) yield i
    println(filteredSeq.toList) // List(3, 6, 9)

    //    You can filter any sequence based on a predicate:
    val predicateSeq = Seq(1, 2, 3, 4, 5)
    val seqWithPredicate = predicateSeq.filter(x => x > 2)
    println(seqWithPredicate) // List(3, 4, 5)

    //    You can also filter Arrays in the same way:
    val filAr = Array(1, 2, 3, 4, 5)
    val arrayWithPredicate = filAr.filter(x => x > 2)
    println(arrayWithPredicate(0)) // 3

    //    You can map values in a sequence through a function:
    val reverseSeq = Seq("Hello", "baby")
    val reversed = reverseSeq map { x => x.reverse }
    println(reversed) // List(olleH, ybab)
  }
}

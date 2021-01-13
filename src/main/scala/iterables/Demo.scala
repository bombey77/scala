package iterables

object Demo {

  def main(args: Array[String]): Unit = {
    val list = List(3, 5, 9, 11, 15, 19, 21)
    val it = list.iterator
    if (it.hasNext)
      println(it.next) // 3 => Note! It returns the first element

    //    grouped list
    val groupedList = List(1, 2, 3, 4, 5, 6)
    val groupedIterator = groupedList grouped 3
    println(groupedIterator.next()) // List(1, 2, 3)
    println(groupedIterator.next()) // List(4, 5, 6)

    //    sliding will return an Iterable that shows a sliding window of an Iterable
    val slidingList = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val slidingIterator = slidingList sliding 3
    println(slidingIterator.next()) // List(1, 2, 3)
    println(slidingIterator.next()) // List(2, 3, 4)
    println(slidingIterator.next()) // List(3, 4, 5)
    println(slidingIterator.next()) // List(4, 5, 6) ...

    //    sliding can take the size of the window as well the size of the step during each iteration
    val slidingWithWindowList = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val slWindIterator = slidingList sliding(3, 3)
    println(slWindIterator.next()) // List(1, 2, 3)
    println(slWindIterator.next()) // List(4, 5, 6)
    println(slWindIterator.next()) // List(7, 8, 9)

    //    takeRight is the opposite of 'take' in Traversable. It retrieves the last elements of an Iterable
    val takeList = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(takeList takeRight 3) // List(7, 8, 9)

    //    dropRight will drop a specified number of elements from the right
    val dropList = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(dropList dropRight 4) // List(1, 2, 3, 4, 5)

    //    zip will stitch two iterables into an iterable of pairs of corresponding elements from both iterables.
    //    e.g. Iterable(x1, x2, x3) zip Iterable(y1, y2, y3) will return ((x1, y1), (x2, y2), (x3, y3))
    val leftList = List(1, 2, 3)
    val rightList = List("Bob", "John", "Kathy")
    println(leftList.zip(rightList)) // List((1,Bob), (2,John), (3,Kathy))

    //    If two Iterables aren't the same size, then zip will only zip what can be paired.
    //    e.g. Iterable(x1, x2, x3) zip Iterable(y1, y2) will return ((x1, y1), (x2, y2))
    val xs = List(1, 2)
    val ys = List("Bob", "Kathy", "Mark")
    println(xs zip ys) // List((1, "Bob"), (2, "Kathy"))

    //    If two Iterables aren't the same size, then zipAll can provide fillers for what it couldn't find a complement for.
    //    e.g. Iterable(x1, x2, x3) zipAll (Iterable(y1, y2), x, y) will return ((x1,y1), (x2, y2), (x3, y)))
    val ll = List(1, 2, 3)
    val rl = List("Bob", "Mindy")
    println(ll zipAll(rl, -1, "?")) // List((1, "Bob"), (2, "Mindy"), (3, "?"))

    //    zipWithIndex will zip an Iterable with its integer index
    val zipList = List("Bob", "Suzy", "Mark", "Steven")
    println(zipList zipWithIndex) // List(("Bob", 0), ("Suzy", 1), ("Mark", 2), ("Steve", 3))

    //    sameElements will return true if the two Iterables produce the same elements in the same order.
    //    The iterator for a set created with less than 5 values will return elements in the order in which they
    //    were added, rather than the consistent, hash-based ordering used by iterators for larger Sets
    val x1 = List("Manny", "Moe", "Jack")
    val y1 = List("Manny", "Moe", "Jack")
    println(x1.iterator.sameElements(y1)) // true

    val x2 = List("Manny", "Moe", "Jack")
    val y2 = List("Manny", "Jack", "Moe")
    println(x2.iterator.sameElements(y2)) // false

    val x3 = Set(3, 2, 1, 4, 5, 6, 7)
    val y3 = Set(7, 2, 1, 4, 5, 6, 3)
    println(x3.iterator.sameElements(y3)) // true

    val x4 = Set(1, 2, 3)
    val y4 = Set(3, 2, 1)
    println(x4.iterator.sameElements(y4)) // false
  }
}

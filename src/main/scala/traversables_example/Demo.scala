package traversables_example

import scala.collection.immutable.LazyList.cons

object Demo {

  def main(args: Array[String]): Unit = {
    //    Traversables are the superclass of List, Array, Map, Set, Stream and more. The methods involved can be
    //    applied to each other in a different type. ++ appends two Traversables together. The resulting Traversable
    //    is the same type of the first element.
    val set = Set(1, 9, 10, 22)
    val list = List(3, 4, 5, 10)
    val result = set ++ list
    println(result.size) // 7 (it returns Set of elements)

    val result2 = list ++ set // (it returns List of elements)
    println(result2.size)

    //    map will apply the given function on all elements of a Traversable and return a new collection of the result
    val dl = List(1, 2, 3, 4)
    val mapRes = dl map {
      _ * 2
    }
    println(mapRes) // List(2, 4, 6, 8)

    //    flatten will "pack" all child Traversables into a single Traversable:
    val flList = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
    println(flList.flatten) // List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    //    flatMap will not only apply the given function on all elements of a Traversable,
    //    but all elements within the elements and flatten the results
    val d = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
    val flMapWithMap = d flatMap {
      _ map {
        _ * 4
      }
    }
    //    val flMapWithMap = d.flatMap(_.map(_ * 4))
    println(flMapWithMap) // List(4, 8, 12, 16, 20, 24, 28, 32, 36, 40)

    //    flatMap of Options will filter out all Nones but keep the Somes
    val q = List(1, 2, 3, 4, 5)
    val qRes = q.flatMap(it => if (it % 2 == 0) Some(it) else None)
    println(qRes) // List(2, 4)

    //    collect will apply a partial function to all elements of a Traversable and return a different collection.
    //    In this exercise, a case fragment is a partial function
    val lc = List(4, 6, 7, 8, 9, 13, 14)
    val lcResult = lc.collect {
      case x: Int if (x % 2 == 0) => x * 3
    }
    println(lcResult) // List(12, 18, 24, 42)

    //    Two case fragments can be chained to create a more robust result
    val partList = List(4, 6, 7, 8, 9, 13, 14)
    val partialFunction1: PartialFunction[Int, Int] = {
      case x: Int if x % 2 == 0 => x * 3
    }
    val partialFunction2: PartialFunction[Int, Int] = {
      case y: Int if y % 2 != 0 => y * 4
    }
    val partRes = partList.collect(partialFunction1 orElse partialFunction2)
    println(partRes) // List(12, 18, 28, 24, 36, 52, 42)

    //    foreach will apply a function to all elements of a Traversable, but unlike the map function,
    //    it will not return anything since the return type is Unit - an equivalent to a void return type in Java/C++
    val feList = List(4, 6, 7, 8, 9, 13, 14)
    feList.foreach(num => println(num * 4))
    println(feList) // List(4, 6, 7, 8, 9, 13, 14)

    //    Given a from index, and a to index, slice will return the part of the collection including from, and excluding to
    val slList = List(10, 19, 45, 1, 22)
    println(slList.slice(1, 3)) // List(19, 45)

    //    take is used often with LazyList, since they are also Traversable
    def makeLazyList(v: Int): LazyList[Int] = cons(v, makeLazyList(v + 1))

    val a = makeLazyList(2)
    println(a take 3 toList) // List(2, 3, 4)
    //    drop will take the rest of the Traversable except the number of elements given
    println(((a drop 6) take 3).toList)

    //    splitAt will split a Traversable at a position, returning a 2 product Tuple.
    //    splitAt is also defined as (xs take n, xs drop n)
    val arraySplit = Array(87, 44, 5, 4, 200, 10, 39, 100)
    val splitRes = arraySplit splitAt 3
    println(splitRes._1) // Array(87, 44, 5)
    println(splitRes._2) // Array(4, 200, 10, 39, 100)

    //    span will split a Traversable according to a predicate, returning a 2 product Tuple.
    //    span is also defined as (xs takeWhile p, xs dropWhile p)
    val arraySpan = Array(87, 44, 5, 4, 200, 10, 39, 100)
    val spanRes = arraySpan span (_ < 100)
    println(spanRes._1) // Array(87, 44, 5, 4)
    println(spanRes._2) // Array(200, 10, 39, 100)

    //    partition will split a Traversable according to a predicate, returning a 2 product Tuple.
    //    The left-hand side contains the elements satisfied by the predicate whereas the right hand side contains the rest of the elements. partition is also defined as (xs filter p, xs filterNot p)
    val arrayPartition = Array(87, 44, 5, 4, 200, 10, 39, 100)
    val partitionRes = arrayPartition span (_ < 100)
    println(partitionRes._1) // Array(87, 44, 5, 4, 10, 39)
    println(partitionRes._2) // Array(200, 100)

    //    forall will determine if a predicate is valid for all members of a Traversable
    val forAllList = List(87, 44, 5, 4, 200, 10, 39, 100)
    val forAllRes = forAllList forall (_ < 100)
    println(forAllRes) // false

    //    exists will determine if a predicate is valid for some members of a Traversable
    val existsList = List(87, 44, 5, 4, 200, 10, 39, 100)
    val existsRes = existsList exists (_ < 100)
    println(existsRes) // true

    //    foldLeft will combine an operation starting with a seed and combining from the left. foldLeft takes as a
    //    first parameter the initial value of the fold. Once the fold is established, you provide a function that
    //    takes two arguments. The first argument is the running total of the operation, and the second element is
    //    the next element of the list.
    //    Given a Traversable (x1, x2, x3, x4), an initial value of init, an operation op, foldLeft is defined
    //    as: (((init op x1) op x2) op x3) op x4)
    val foldLeftList = List(5, 4, 3, 2, 1)
    val foldLeftRes = foldLeftList.foldLeft(0) { (`running total`, `next element`) =>
      `running total` - `next element`
    }
    println(foldLeftRes) // -15
    val foldLeftRes2 = foldLeftList.foldLeft(0)(_ - _) //Short hand
    println(foldLeftRes2) // -15
    println((((((0 - 5) - 4) - 3) - 2) - 1)) // -15

    //    foldRight will combine an operation starting with a seed and combining from the right.
    //    foldRight takes as a first parameter the initial value of the fold. Once the fold is established,
    //    you provide a function that takes two elements. The first is the next element of the list,
    //    and the second element is the running total of the operation.
    //    Given a Traversable (x1, x2, x3, x4), an initial value of init, an operation op, foldRight is defined
    //    as: x1 op (x2 op (x3 op (x4 op init)))
    val foldRightList = List(5, 4, 3, 2, 1)
    val foldRightRes = foldRightList.foldRight(0) { (`next element`, `running total`) =>
      `next element` - `running total`
    }
    println(foldRightRes) // 3
    val foldRightRes2 = foldRightList.foldRight(0)(_ - _) //Short hand
    println(foldRightRes2) // -6
    println((5 - (4 - (3 - (2 - (1 - 0)))))) // 3

    //    reduceLeft is similar to foldLeft, except that the seed is the head value
    val reduceLeftList = List(5, 4, 3, 2, 1)
    println(reduceLeftList.reduceLeft {
      _ + _
    }) // 15

    val reduceLeftStringList = List("Do", "Re", "Me", "Fa", "So", "La", "Te", "Do")
    println(reduceLeftStringList.reduceLeft {
      _ + _
    }) // DoReMeFaSoLaTeDo

    //    reduceRight is similar to foldRight, except that the seed is the last value
    val reduceRightList = List(5, 4, 3, 2, 1)
    println(reduceRightList.reduceRight {
      _ + _
    }) // 15

    val reduceRightStringList = List("Do", "Re", "Me", "Fa", "So", "La", "Te", "Do")
    println(reduceRightStringList.reduceRight {
      _ + _
    }) // DoReMeFaSoLaTeDo

    //    transpose will take a traversable of traversables and group them by their position in it's own traversable,
    //    e.g.: ((x1, x2),(y1, y2)).transpose = (x1, y1), (x2, y2) or ((x1, x2, x3),(y1, y2, y3),
    //    (z1, z2, z3)).transpose = ((x1, y1, z1), (x2, y2, z2), (x3, y3, z3))
    val transposeList = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    println(transposeList transpose) //
    val transposeList2 = List(List(1), List(4)) // List(List(1, 4, 7), List(2, 5, 8), List(3, 6, 9))
    println(transposeList2 transpose) // List(List(1, 4))

    //    mkString will format a Traversable using a given string as the delimiter
    val mkStringList = List(1, 2, 3, 4, 5)
    println(mkStringList.mkString(",")) // 1,2,3,4,5  NOTE! as String

    val mkStringListWithStartAndEnd = List(1, 2, 3, 4, 5)
    println(mkStringListWithStartAndEnd mkString(">", ",", "<")) // >1,2,3,4,5<

    val stringBuilder = new StringBuilder()
    val builderList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    stringBuilder.append("I want all numbers 6-12: ")
    builderList.filter(it => it > 5 && it < 13).addString(stringBuilder, ",")
    println(stringBuilder.mkString) // I want all numbers 6-12: 6,7,8,9,10,11,12


  }
}

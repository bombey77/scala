package for_comprehension

import scala.collection.immutable.Range
import scala.runtime.RichInt

object Demo {

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10) {
      println(i)
    }
    // the same as previous for
    for (i <- 1.to(10)) {
      println(i)
    }
    // the same as previous for
    val range0: Range = 1 to 10
    for (i <- range0) {
      println(i)
    }
    // the same as previous for
    val range1: Range = new RichInt(1).to(10)
    for(i <- range1) {
      println(i)
    }
  }
}

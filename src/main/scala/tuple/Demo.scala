package tuple

object Demo {

  def main(args: Array[String]): Unit = {
    val t2 = (1, "Roman") // can contains different types
    val t3 = (2, "Kathy", 11.34)
    val (id, name, score) = t3
    println(id) // 2
    println(name) // Kathy
    println(score) // 11.34

    val e2 = (12, "Some value").swap
    println(e2._1) // Some value
    println(e2._2) // 12
  }
}

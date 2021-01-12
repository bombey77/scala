package case_class

object Disassembled {

  def main(args: Array[String]): Unit = {
//    Case classes can be disassembled to their constituent parts as a tuple:
    val person = Person("Roman", 34)
    val parts = Person.unapply(person).get
    println(parts._1) // Roman
    println(parts._2) // 34
  }

  case class Person(name: String, age: Int)
}



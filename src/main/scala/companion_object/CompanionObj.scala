package companion_object

class CompanionObj(val name: String) {
  private val x: String = "Private variable"
}

// An object that has the same name as a class is called a companion object of the class,
// and it is often used to contain factory methods for the class that it complements
object CompanionObj {

  def verifyName(name: String): Boolean = name match {
    case "Roman" => true
    case "Kathy" => false
    case _ => false
  }

  def printPrivateVarFromClass(): Unit = {
    val companionObj = new CompanionObj("Roman")
    println(companionObj.x)
  }

  def main(args: Array[String]): Unit = {
    println(CompanionObj.verifyName("Roman")) // true
    printPrivateVarFromClass() // Private variable
  }
}

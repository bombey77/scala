package repeated_parameters

object Demo {

  def main(args: Array[String]): Unit = {
    //  "3 eggs can give you a delicious sandwich, protein, high cholesterol"
    println(repeatedParameterMethod(3, "egg", "a delicious sandwich", "protein", "high cholesterol"))

    //  3 eggs can give you List(a delicious sandwich, protein, high cholesterol)
    println(repeatedParameterMethod(3, "egg", List("a delicious sandwich", "protein", "high cholesterol")))

//    A repeated parameter can accept a collection - if you want it expanded, add :_*
    println(repeatedParameterMethod(3, "egg", List("a delicious sandwich", "protein", "high cholesterol"): _*))
  }

  //  A repeated parameter must be the last parameter and this will let you add as many extra parameters as needed
  def repeatedParameterMethod(x: Int, y: String, z: Any*) = {
    "%d %ss can give you %s".format(x, y, z.mkString(", "))
  }
}

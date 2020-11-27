import java.util.{ArrayList => AList} //import ArrayList and rename as AList
import java.util.{TreeMap, HashMap => HMap, HashSet => HSet}  //Note you can rename whatever you want in package
import java.io.{StringWriter =>  SW, _} //in this case I rename only StringWriter in package and left _ (other classes)

object Demo4 {

  def main(args: Array[String]): Unit = {
    val list = new AList()
    val hMap = new HMap()
    val tMap = new TreeMap()
    val hSet = new HSet()
    val sw = new SW()
    val sr = new StringReader("reader")
  }
}

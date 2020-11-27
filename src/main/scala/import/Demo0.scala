import java.io._  //import whole package
import java.util.ArrayList  //import only one class
import java.util.{HashMap, TreeMap}   //import two classes

object Demo0 {

  def main(args: Array[String]): Unit = {
    val list = new ArrayList[String]
    val map = new HashMap[String, TreeMap[String, String]]
    val writer = new StringWriter()
  }
}

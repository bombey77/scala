
object Demo6 {

  import java.util.ArrayList
  val list: ArrayList[String] = null  //Note you can import inside Object

  def prFunction() = {
    import java.util.HashMap  //Note you can import inside function
    val hMap: HashMap[String, String] = null
  }
}

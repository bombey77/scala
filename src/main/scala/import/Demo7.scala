import java.util  //Note here I import only name util but not the package

object Demo7 {

  val list = new util.ArrayList()

  import util._ //here I import whole package
  val hMap = new HashMap()
}

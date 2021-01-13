package self_type

object Demo {
  def main(args: Array[String]): Unit = {
    // there's a good video lesson
    // https://www.youtube.com/watch?v=ZnpB4B1fMSI
  }
}

trait Engine

trait Car {
  def hasEngine(e: Engine): Boolean
}
trait Mercedes extends Car
trait BMW extends Car

trait Glass { self: Car => // self-type -> whoever extends Glass must also extends Car
  def hasEngine(e: Engine): Boolean
}
trait PlasticGlass extends Glass with Car
trait RegularGlass extends Glass with Car

class Test extends Car with Glass {
  override def hasEngine(e: Engine): Boolean = ???
}
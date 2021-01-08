package require_example

object Demo {

  def main(args: Array[String]): Unit = {
    val x: Int = 1
    // require используется для валидации данных
    // require нельзя отключить, т.к. это можно сделать с assert
    require(x == 1)
    require(x == 1, "x should equals 1")
  }
}

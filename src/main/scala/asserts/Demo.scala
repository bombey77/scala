package asserts

object Demo {

  def main(args: Array[String]): Unit = {
    val left = 2
    val right = 2
    // assert отлавливает ситуации, которые мы не ожидаем от выполнения нашей программы
    assert(left == right)
  }
}

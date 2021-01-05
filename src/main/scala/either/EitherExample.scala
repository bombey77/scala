package either

object EitherExample {

  def verify(x: Double): Either[String, Double] = {
    if (x < 0) Left("x must be positive")
    else Right(x)
  }

  def main(args: Array[String]): Unit = {
    println(verify(12)) // Right(12.0)
    println(verify(-12)) // Left(x must be positive)

    // Since Scala 2.12, Either has map and flatMap. These methods transform the Right case only.
    // We say that Either is “right biased”:
    println(Right(1).map(x => x + 1)) // Right(2)
    println(Right(1) map { x => x + 1 }) // Right(2)
    println(Right(1).map((x: Int) => x + 1)) // Right(2)
    println(Left("foo").map((x: Int) => x + 1)) // Left(foo)
  }
}

package either

object EitherExample {

  def verify(x: Double): Either[String, Double] = {
    if (x < 0) Left("x must be positive")
    else Right(x)
  }

  def main(args: Array[String]): Unit = {
    println(verify(12)) // Right(12.0)
    println(verify(-12)) // Left(x must be positive)
  }
}

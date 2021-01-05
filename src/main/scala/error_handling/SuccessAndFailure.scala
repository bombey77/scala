package error_handling

import scala.util.{Failure, Success, Try}

object SuccessAndFailure {

  def verify(x: Double): Try[Double] = {
    if (x < 0) Failure(new IllegalArgumentException("x must be positive"))
    else Success(x)
  }

  def main(args: Array[String]): Unit = {
    println(verify(12)) // Success(12.0)
    println(verify(-12)) // Failure(java.lang.IllegalArgumentException: x must be positive)
  }
}

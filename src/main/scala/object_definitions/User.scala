package object_definitions

abstract class User

object Empty extends User {
  // This defines a singleton object named Empty.
  // No other Empty instances can be (or need to be) created.
  def create(): User = new NonEmpty(Empty) // <-- look, how I pass Empty
}

class NonEmpty(user: User) extends User {

  def create(): User = new NonEmpty(user)
}

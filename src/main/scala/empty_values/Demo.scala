package empty_values

object Demo {

  //  null
  //  Scala's null is the same as in Java. Any reference type can be null, like Strings, Objects,
  //  or your own classes. Also just like Java, value types like Ints can't be null.

  //  Null
  //  Null is a trait whose only instance is null. It is a subtype of all reference types, but not of value types.
  //  Its purpose in existing is to make it so reference types can be assigned null and value types can't.

  //  Nothing
  //  Nothing is a trait that is guaranteed to have zero instances. It is a subtype of all other types.
  //  It has two main reasons for existing: to provide a return type for methods that never return
  //  normally (i.e. a method that always throws an exception). The other reason is to provide a type
  //  for Nil (explained below).

  //  Unit
  //  Unit in Scala is the equivalent of void in Java. It's used in a function's signature when that
  //  function doesn't return a value.

  //  Nil
  //  Nil is just an empty list, exactly like the result of List(). It is of type List[Nothing].
  //  And since we know there are no instances of Nothing, we now have a list that is statically
  //  verifiable as empty. Nice to have.
  //

  def main(args: Array[String]): Unit = {
    //    An empty list can be represented by another nothing value: Nil
    println(List() == Nil) // true
    //    None equals None
    println(None == None) // true
    //    None should be identical to None
    println(None eq None) // true
    //    None can be converted to a String
    println(None.toString == "None") // true
    //    None can be converted to an empty list
    println(None.toList == Nil) // true
    //    None is considered empty
    println(None.isEmpty) // true
    //    None can be cast to Any, AnyRef or AnyVal
    println(None.isInstanceOf[Any]) // true
    println(None.isInstanceOf[AnyRef]) // true
    //    None can be used with Option instead of null references
    val optional: Option[String] = None
    println(optional.isEmpty) // true
    println(optional == None) // true
    //    Some is the opposite of None for Option types
    val opt: Option[String] = Some("some value")
    println(opt.isEmpty) // false
    println(opt == None) // false
    //    Option.getOrElse can be used to provide a default in the case of None 😀
    val o: Option[String] = None
    println(o getOrElse "default value") // default value
  }
}

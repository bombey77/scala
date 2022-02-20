package generics

class MyClass[T] {}

// [T] - invariant (nonvariant)
// [+T] - covariant class
// [-T] - contravariant class
object Demo extends App {

  // case [T]
  //  val t1: MyClass[Object] = new MyClass[String] -> ERROR!!!
  //  val t2: MyClass[String] = new MyClass[Object] -> ERROR!!!
  //  val t3: MyClass[String] = new MyClass[String]

  // case [+T]
  //  val t1: MyClass[Object] = new MyClass[String]
  //  val t2: MyClass[String] = new MyClass[Object] -> ERROR!!!
  //  val t3: MyClass[String] = new MyClass[String]

  // case [-T]
  //  val t1: MyClass[Object] = new MyClass[String] -> ERROR!!!
  //  val t2: MyClass[String] = new MyClass[Object]
  //  val t3: MyClass[String] = new MyClass[String]
}

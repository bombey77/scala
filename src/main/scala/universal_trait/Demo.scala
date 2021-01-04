package universal_trait

// 0. Universal trait + custom value classes - ephemeral constructions
// 1. Only trait can extends Any
// 2. Universal trait = explicitly extends Any
// - only methods
// - no val/var
// - no constructor / initialization statements
// - no nested structures

// UNIVERSAL TRAIT
trait Demo extends Any {
  def print() = Console.print(this)
  def println() = Console.println(this)
}

// NOR UNIVERSAL TRAIT, implicitly 'extends AnyRef'
trait Demo1 {
  def print() = Console.print(this)
  def println() = Console.println(this)
}

// NOR UNIVERSAL TRAIT
// - val
// - body -> initialization statements
// - local class definition
trait Demo2 extends App {
  val k = 0
  printf("Hello")
  class Local
  def print() = Console.print(this)
  def println() = Console.println(this)
}

// Compile error - Only trait can extends Any
//class Demo extends Any
//object Demo extends Any



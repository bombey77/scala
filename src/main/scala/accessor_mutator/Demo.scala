package accessor_mutator

object Demo {

  def main(args: Array[String]): Unit = {
    val p = new Person
    p.setAge(12);
    print(p.getAge());
  }
}

class Person {

  // знак _ это инициализация age значением 0 (без инициализации не компилируется)
  private var age: Int = _

  // accessor
  def getAge(): Int = age

  // mutator
  def setAge(age: Int): Unit = {
    this.age = age;
  }
}

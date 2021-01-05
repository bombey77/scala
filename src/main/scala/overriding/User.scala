package overriding

trait User {
  def hasAuthority()
}

class Guest extends User {
  override def hasAuthority(): Unit = false
}

class Admin extends Guest {
  override def hasAuthority(): Unit = true
}

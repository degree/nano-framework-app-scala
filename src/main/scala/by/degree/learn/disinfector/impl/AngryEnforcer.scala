package by.degree.learn.disinfector.impl

import by.degree.learn.disinfector.model.Enforcer
import by.degree.learn.nano.framework.{InjectProperty, PostConstruct, Primary}

@Primary
class AngryEnforcer extends Enforcer {

  @InjectProperty("enforcer.enhanced.name")
  private[this] var name: String = _

  override def enforce(): Unit = println(s"$name: get out!")

  @PostConstruct
  def init() = println(s"$name is getting angry...")
}

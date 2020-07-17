package by.degree.learn.disinfector.impl

import by.degree.learn.disinfector.model.Enforcer
import by.degree.learn.nano.framework.{Component, InjectProperty}

@Component
class DefaultEnforcer extends Enforcer {

  @InjectProperty("enforcer.default.name")
  private[this] var name: String = _

  override def enforce(): Unit = println(s"$name: Leave the room!")
}

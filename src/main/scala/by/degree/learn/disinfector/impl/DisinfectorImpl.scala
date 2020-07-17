package by.degree.learn.disinfector.impl

import by.degree.learn.disinfector.model.{Disinfector, Enforcer, Room}
import by.degree.learn.nano.framework.{Inject, Singleton}

@Singleton
class DisinfectorImpl extends Disinfector {

  @Inject
  private[this] val enforcer: Enforcer = null

  override def disinfect(room: Room): Unit = {
    enforcer.enforce()
    doDisinfection(room)
  }

  private def doDisinfection(room: Room): Unit = println(s"Disinfecting $room")

}

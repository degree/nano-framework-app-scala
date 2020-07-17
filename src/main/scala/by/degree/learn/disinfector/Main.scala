package by.degree.learn.disinfector

import by.degree.learn.disinfector.model.{Disinfector, Room}
import by.degree.learn.nano.framework.Application

object Main extends App {
  Application.run("by.degree.learn.disinfector")
    .getObject(classOf[Disinfector])
    .disinfect(Room("laboratory"))
}

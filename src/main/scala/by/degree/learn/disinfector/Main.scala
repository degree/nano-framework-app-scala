package by.degree.learn.disinfector

import by.degree.learn.disinfector.model.{Disinfector, Room}
import by.degree.learn.nano.framework.Application

object Main extends App {
  private val context = Application.run("by.degree.learn.disinfector")
  private val disinfector = context.getObject(classOf[Disinfector])
  disinfector.disinfect(Room("laboratory"))
}

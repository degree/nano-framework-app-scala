package by.degree.learn.disinfector.infrastructure

import java.lang.reflect.{InvocationHandler, Method, Proxy}
import java.util

import by.degree.learn.nano.framework.{Component, ProxyConfigurer}

@Component
class AnnouncerProxy extends ProxyConfigurer {
  override def wrapIfNeeded(t: Any, implClass: Class[_]): Any = {
    val hasMethods = util.Arrays.stream(implClass.getDeclaredMethods).anyMatch(AnnouncerProxy.hasAnnotation)
    if (hasMethods)
      if (implClass.getInterfaces.length != 0) Proxy.newProxyInstance(implClass.getClassLoader, implClass.getInterfaces, buildHandler(t))
      else throw new RuntimeException(s"Classes are not supported: $implClass")
    else t
  }

  private def buildHandler(t: Any): InvocationHandler = (proxy: Any, method: Method, args: Array[AnyRef]) => {
    val wrap = AnnouncerProxy.hasAnnotation(t.getClass.getMethod(method.getName, method.getParameterTypes: _*))
    val rendered = if (wrap) AnnouncerProxy.render(args: _*) else null
    if (wrap) println(s"Announce disinfection: leave $rendered")

    val result = method.invoke(t, args: _*)

    if (wrap) println(s"Announce disinfection: complete $rendered")

    result
  }
}

object AnnouncerProxy {
  def hasAnnotation(method: Method): Boolean = method.isAnnotationPresent(classOf[Announce])

  def render(args: Any*): Some[String] = Some(args.map(_.toString).mkString(", "))
}

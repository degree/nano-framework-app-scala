name := "nano-framework-app-scala"

version := "0.1"

scalaVersion := "3.0.0"

resolvers += "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository"

libraryDependencies += "by.degree.learn" % "nano-framework" % "1.0-SNAPSHOT"

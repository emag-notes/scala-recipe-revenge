name := """chapter08"""

version := "1.0"

scalaVersion := "2.11.1"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.6" % "test"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.3"

libraryDependencies ++= Seq(
  "com.github.pathikrit" % "dijon_2.11" % "0.2.4",
  "org.scala-lang.modules" % "scala-swing_2.11" % "1.0.1",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
)

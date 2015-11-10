enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"

scalaVersion := "2.11.7" // or any other Scala version >= 2.10.2

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0"
// core = essentials only. No bells or whistles.
libraryDependencies += "com.greencatsoft" %%% "scalajs-angular" % "0.6"

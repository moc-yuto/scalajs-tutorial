enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"

scalaVersion := "2.11.7" // or any other Scala version >= 2.10.2

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0",
  "com.greencatsoft" %%% "scalajs-angular" % "0.6",
  "com.github.benhutchison" %%% "prickle" % "1.1.4"
)


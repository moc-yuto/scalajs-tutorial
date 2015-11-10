enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"

scalaVersion := "2.11.7" // or any other Scala version >= 2.10.2

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0"
// core = essentials only. No bells or whistles.
libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "0.10.1"

// React JS itself (Note the filenames, adjust as needed, eg. to remove addons.)
jsDependencies += "org.webjars.npm" % "react"     % "0.14.1" / "react-with-addons.js" commonJSName "React"    minified "react-with-addons.min.js"
jsDependencies += "org.webjars.npm" % "react-dom" % "0.14.1" / "react-dom.js"         commonJSName "ReactDOM" minified "react-dom.min.js" dependsOn "react-with-addons.js"

val libV = "0.1.0-SNAPSHOT"
val scalaV = "2.12.2"

scalaVersion := scalaV

val commonSettings = Seq(
  organization := "com.github.lettenj61",
  version := libV,
  scalaVersion := scalaV,

  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.1",
    "com.lihaoyi" %%% "utest" % "0.4.6" % Test
  ),
  testFrameworks += new TestFramework("utest.runner.Framework"),

  scalacOptions in (Compile, compile) ++= Seq() /*
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-unchecked",
    "-Xlint",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Ywarn-unused-import",
    "-Ywarn-unused"
  ) */
)

val domSettings = Seq(
  requiresDOM := true,
  jsEnv := PhantomJSEnv().value
)

lazy val mavo = project
  .in(file("scalajs-mavo"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings: _*)
  .settings(
    name := "scalajs-mavo",
    libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.5"
  )

lazy val example = project
  .in(file("mavo-examples"))
  .dependsOn(mavo)
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings((commonSettings ++ domSettings): _*)
  .settings(
    name := "scalajs-mavo-examples"
  )

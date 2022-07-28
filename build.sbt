ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "Datumo_recruitment_assignment",
    idePackagePrefix := Some("io.datumo.recruitment")

  )
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.11"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"
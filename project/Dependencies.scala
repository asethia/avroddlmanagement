import Versions._
import sbt._

object Dependencies {


  //scala related
  object Scala {
    val scalazCore = "org.scalaz" %% "scalaz-core" % scalazV
  }

  val scalaLib = Seq(Scala.scalazCore)

  //logging related
  object Logging {
    val logback = "ch.qos.logback" % "logback-classic" % Logback
    val logstashLogback = "net.logstash.logback" % "logstash-logback-encoder" % logstashLogbackV
    val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingV
    val log4jAPI = "org.apache.logging.log4j" % "log4j-api" % log4jAPIV
  }

  val loggingLib = Seq(Logging.logback, Logging.logstashLogback, Logging.scalaLogging, Logging.log4jAPI)


  //testing related
  object Test {
    val scalatest = "org.scalatest" %% "scalatest" % scalaTestV % "test"
    val mockito = "org.mockito" % "mockito-core" % mockitoV % "test"
    val scalaMock = "org.scalamock" %% "scalamock-scalatest-support" % "3.4.2" % "test"
  }

  val testLib = Seq(Test.scalatest, Test.mockito, Test.scalaMock)

  //avro related
  object Avro {
    val avro = "org.apache.avro" % "avro" % avroV
    //avro json to schema
    val avro4sJson = "com.sksamuel.avro4s" % "avro4s-json_2.11" % avro4sJsonV
  }

  val avroLib = Seq(Avro.avro, Avro.avro4sJson)

  val basicDeps = testLib ++ loggingLib ++ scalaLib ++ avroLib
}



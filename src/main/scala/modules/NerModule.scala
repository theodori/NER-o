package ner.modules

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, PrintWriter}

import scala.sys.process.{ProcessLogger, _}

trait NerModule {
  def runCommand(cmd: String, data: Option[String]): (Int, String, String) = {
    val datas = new ByteArrayInputStream(data.getOrElse("").getBytes)
    val stdoutStream = new ByteArrayOutputStream
    val stderrStream = new ByteArrayOutputStream
    val stdoutWriter = new PrintWriter(stdoutStream)
    val stderrWriter = new PrintWriter(stderrStream)
    val exitValue = (cmd #< datas) ! (ProcessLogger(stdoutWriter.println, stderrWriter.println))
    stdoutWriter.close()
    stderrWriter.close()
    (exitValue, stdoutStream.toString, stderrStream.toString)
  }

  def process
  (
    input: String
  ): Some[String]
}

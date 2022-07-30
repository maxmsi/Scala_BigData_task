package io.datumo.recruitment

import java.io.{BufferedWriter, File, FileNotFoundException, FileWriter, IOException}
import scala.io.Source

class FileIO {

  def readTxtFile(fileName: String): Either[String, String] = {
    try {
      val file: Iterator[String] = Source.fromResource(fileName).getLines
      Right(file.mkString)
    } catch {
      case e: FileNotFoundException => Left("Couldn't find that file.")
      case e: IOException => Left("Had an IOException trying to read that file")
      case e: UnsupportedOperationException => Left("Unsupported Operation Exception")
    }
  }

  def convertInputToList(input: String): List[Int] = {
    input.split(",").map(x => x.toInt).toList
  }

  def saveFileToTxt(filename: String, lines: List[List[Int]]): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))
    val tuples: List[(Int, Int)] = lines.map { case List(a, b) => (a, b) }
    for (line <- tuples) {
      bw.write(s"$line\n")
    }
    bw.close()
  }

}

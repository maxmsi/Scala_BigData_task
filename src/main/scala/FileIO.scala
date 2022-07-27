package io.datumo.recruitment

import java.io.{BufferedWriter, File, FileNotFoundException, FileWriter, IOException}
import java.net.URI
import java.nio.file.{Path, Paths}
import java.time.LocalDateTime
import scala.io.Source
import scala.sys.runtime

class FileIO {

  def readTxtFile(path: Path): String = {
    val file = Source.fromFile(path.toFile)
    try {
      file.mkString
    } catch {
      case e: FileNotFoundException => ("Couldn't find that file.")
      case e: IOException => ("Had an IOException trying to read that file")
      case e: UnsupportedOperationException => ("Unsupported Operation Exception")
    }
    finally {
      file.close()
    }

  }

  def convertInputToList(input: String): List[Int] = {
    input.split(",").map(x => x.toInt).toList
  }

  def saveFileToTxt(filename: String, lines: List[List[Int]]): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))
    val tuples: List[(Int, Int)] = lines.map{ case List(a,b) => (a,b)}
    for (line <- tuples) {
      bw.write(s"$line\n")
    }
    bw.close()
  }
}
object Tester {
  def main(args: Array[String]) = {
    val fileIo = new FileIO()
    val pf= new PairFinder

    val path = Paths.get(URI.create("file:///E:/SparkScalaCourse/Datumo_recruitment_assignment/src/main/resource/input.txt"))
    val str = fileIo.readTxtFile(path)
    val input = fileIo.convertInputToList(str)

    val convertedResultToSave=(pf.task_algorithm(input,12))
    fileIo.saveFileToTxt("ResultFile",convertedResultToSave)
  }
}

package io.datumo.recruitment

import scala.io.StdIn.readLine
import scala.util.control.Breaks.{break, breakable}

object Main {

  def main(args: Array[String]): Unit = {
    val pairFinder = new PairFinder
    val fileHandler = new FileIO
    var flag = true

    while (flag) {
      breakable {

        println("Provide file name from resource's: (hint: input.txt) \n To exit provide ' X '")
        val userInput = readLine()
        if (userInput == "X") flag = false
        val fileToList = fileHandler.readTxtFile(userInput).map(fileHandler.convertInputToList) match {
          case Right(x) => x
          case Left(message) => println(message); break
        }

        println("Provide target sum of pair number :")
        val input2 = readLine()
        if (!input2.forall(Character.isDigit)) {
          println("Please, provide a valid number!");
          break
        }
        val result = pairFinder.taskAlgorithm(fileToList, input2.toInt)
        println("Provide file name to save: \n ")
        val userInput3 = readLine()
        fileHandler.saveFileToTxt(userInput3, result)
        flag = false
      }
    }
  }
}

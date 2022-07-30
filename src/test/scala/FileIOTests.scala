package io.datumo.recruitment

import org.scalatest.funsuite.AnyFunSuite

class FileIOTests extends AnyFunSuite {
  val fileHandlerMock = new FileIO
  test("FileIO.readTxtFile should print Couldn't find that file.") {
    assert(fileHandlerMock.readTxtFile("nothing.txt") === Left("Couldn't find that file."))
  }

  test("FileIO.readTxtFile should return lines from valid input file") {
    assert(fileHandlerMock.readTxtFile("input.txt") === Right("4,8,9,0,12,1,4,2,12,12,4,4,8,11,12,0"))
  }

  test("FileIO.readTxtFile should convert string into List[Int]") {
    val lines = "4,8,9,0,12,1,4,2,12,12,4,4,8,11,12,0"
    val input = List[Int](4, 8, 9, 0, 12, 1, 4, 2, 12, 12, 4, 4, 8, 11, 12, 0)
    assert(fileHandlerMock.convertInputToList(lines) === input)
  }
}

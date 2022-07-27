package io.datumo.recruitment

import org.scalatest.funsuite.AnyFunSuite


class PairFinderTests extends AnyFunSuite {

  test("PairFinder.task_algorithm() should return valid list of pair's") {
    val inputMock = List[Int](4, 8, 9, 0, 12, 1, 4, 2, 12, 12, 4, 4, 8, 11, 12, 0)
    val resultMock = List(List(0, 12), List(0, 12), List(1, 11), List(4, 8), List(4, 8))

    val pf = new PairFinder
    assert(pf.task_algorithm(inputMock,12) === resultMock)
  }

  test("PairFinder.task_algorithm() should return empty List") {

    val pf = new PairFinder
    assert(pf.task_algorithm(List(),12) === List.empty)
  }

  test("PairFinder.task_algorithm() should return different output than Mock") {
    val inputMock = List[Int](4, 8, 9, 0, 12, 1, 4, 2, 12, 12, 4, 4, 8, 11, 12, 0,9,3)
    val resultMock = List(List(0, 12), List(0, 12), List(1, 11), List(4, 8), List(4, 8))

    val pf = new PairFinder
    assert(pf.task_algorithm(inputMock,12) !== resultMock)
  }


}

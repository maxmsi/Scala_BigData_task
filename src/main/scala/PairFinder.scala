package io.datumo.recruitment

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


class PairFinder {

  def taskAlgorithm(input: List[Int], target: Int): List[List[Int]] = {
    val inputSorted = input.sortWith(_ < _)
    val map: mutable.Map[Int, Int] = mutable.Map(inputSorted.groupBy(identity)
      .view
      .mapValues(_.size).toSeq: _*)
    val pairs: ListBuffer[List[Int]] = ListBuffer.empty[List[Int]]

    for (i <- inputSorted) {
      if (map.contains(target - inputSorted(i)) && map(target - inputSorted(i)) != 0 && map(inputSorted(i)) != 0) {
        pairs += List(inputSorted(i), target - inputSorted(i))
        map(inputSorted(i)) = map(inputSorted(i)) - 1
        map(target - inputSorted(i)) = map(target - inputSorted(i)) - 1
      }
    }
    pairs.toList
  }
}

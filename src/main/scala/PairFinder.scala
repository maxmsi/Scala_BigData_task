package io.datumo.recruitment

import scala.:+
import scala.collection.mutable
import scala.collection.mutable.ListBuffer



class PairFinder {

  def task_algorithm(input: List[Int],target:Int): List[List[Int]] = {
    var map: mutable.Map[Int, Int] = mutable.Map(input.groupBy(identity)
      .view
      .mapValues(_.size).toSeq: _*)
    var pairs: ListBuffer[List[Int]] = ListBuffer.empty[List[Int]]

    for (i <- input) {
      if (map.contains(target - input(i)) && map(target - input(i)) != 0 && map(input(i)) != 0) {
        pairs += List(input(i), target - input(i))
        map(input(i)) = map(input(i)) - 1
        map(target - input(i)) = map(target - input(i)) - 1
      }
    }
    pairs.toList
  }
}

object Tester {
  def main(args: Array[String]) = {
    println("Initial structure")
    val input = List[Int](4, 8, 9, 0, 12, 1, 4, 2, 12, 12, 4, 4, 8, 11, 12, 0).sortWith(_ < _)
    val pf= new PairFinder()
    println(pf.task_algorithm(input,12))
  }
}
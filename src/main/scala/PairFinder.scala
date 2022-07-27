package io.datumo.recruitment

import scala.:+
import scala.collection.mutable
import scala.collection.mutable.ListBuffer



class PairFinder {

  def task_algorithm(input: List[Int],target:Int): List[List[Int]] = {
    val inputSorted=input.sortWith(_ < _)
    var map: mutable.Map[Int, Int] = mutable.Map(inputSorted.groupBy(identity)
      .view
      .mapValues(_.size).toSeq: _*)
    var pairs: ListBuffer[List[Int]] = ListBuffer.empty[List[Int]]

    for (i <- inputSorted.sortWith(_ < _)) {
      if (map.contains(target - inputSorted(i)) && map(target - inputSorted(i)) != 0 && map(inputSorted(i)) != 0) {
        pairs += List(inputSorted(i), target - inputSorted(i))
        map(inputSorted(i)) = map(inputSorted(i)) - 1
        map(target - inputSorted(i)) = map(target - inputSorted(i)) - 1
      }
    }
    pairs.toList
  }
}

object Tester2 {
  def main(args: Array[String]) = {

    val input = List[Int](4, 8, 9, 0, 12, 1, 4, 2, 12, 12, 4, 4, 8, 11, 12, 0).sortWith(_ < _)
    val fileIO=new FileIO()
    val pf= new PairFinder()
    println(pf.task_algorithm(input,12))
  }
}
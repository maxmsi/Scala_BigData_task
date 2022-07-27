import scala.:+
import scala.collection.mutable

val input = List[Int](4,8,9,0,12,1,4,2,12,12,4,4,8,11,12,0).sortWith(_<_)

var target=12

var map:mutable.Map[Int,Int]=mutable.Map.empty
var pairResults:mutable.Map[Int,Int]=mutable.Map.empty
var pairs: List[List[Int]]

map=mutable.Map (input.groupBy(identity).mapValues(_.size).toSeq : _*)

for(i <- input){
  if(map.contains(target-input(i)) && map(target-input(i))!=0 && map(input(i))!=0){

    pairs += (List(input(i),target-input(i)))

    //  print(input(i))
    //  println(target-input(i))

    map(input(i))=map(input(i))-1
    map(target-input(i))=map(target-input(i))-1
    // println("map afte"+map)
  }
}

pairs.foreach(list=>println(list))

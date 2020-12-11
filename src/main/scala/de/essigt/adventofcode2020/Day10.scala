package de.essigt.adventofcode2020

import scala.collection.mutable
import scala.io.Source

/**
 * @author Tim Essig - essig@synyx.de
 */
object Day10 {

  private val results = mutable.HashMap[Int, Long]()

  def part1(filename : String) : Int = {
    val input = loadInput(filename);
    val deviceJoltage = input.max + 3;
    val numbers = (0 :: input) :+ deviceJoltage
    val differences = numbers.sorted.sliding(2).map(l => l.max - l.min).toList
    differences.count(_ == 1) * differences.count(_ == 3)
  }

  def part2(filename : String) : Long = {
    val input = loadInput(filename).sorted;
    calculateValidPermutations(0, input)
  }

  def calculateValidPermutations(head: Int, input: List[Int]) : Long = {

    if(results.contains(head)) {
      results.get(head).get
    } else {
      if (input.isEmpty) {
        results.put(head, 1)
        return 1
      }

      var sum = 0L;
      for( diff <- 1 to 3) {
        val nextAdapter = head + diff
        if( input.contains(nextAdapter) ) {
          val list = input.splitAt(input.indexOf(nextAdapter))
          sum += calculateValidPermutations(nextAdapter, list._2.drop(1))
        }
      }
      results.put(head,sum)
      return sum
    }
  }


  private def loadInput(filename : String): List[Int] = {
    val file = Source.fromFile(filename)
    val numbers = file.getLines().map(_.toInt).toList
    file.close()
    numbers
  }

}

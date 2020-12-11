package de.essigt.adventofcode2020

import scala.io.Source

/**
 * @author Tim Essig - essig@synyx.de
 */
object Day9 {

  def part1(filename: String, size: Int) : Long = {
    loadInput(filename).sliding(size + 1).filter(!isValid(_)).toList.head.last
  }

  def part2(filename: String, size: Int) : Option[Long] = {
    val numbers = loadInput(filename);
    val resultFromPart1 = part1(filename, size)

    for( seqLength <- 2 until numbers.length) {
      val matchingSeq = numbers.sliding(seqLength).find(_.sum == resultFromPart1)
      if(matchingSeq.isDefined) {
        return matchingSeq.map(s => s.min + s.max)
      }
    }
    None
  }

  def isValid(values: List[Long]): Boolean = {
    val lastValue = values.last;
    values.exists(i => values.contains(lastValue-i))
  }

  private def loadInput(filename : String): List[Long] = {
    val file = Source.fromFile(filename)
    val numbers = file.getLines().map(_.toLong).toList
    file.close()
    numbers
  }

}

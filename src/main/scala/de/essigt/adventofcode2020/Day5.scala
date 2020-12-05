package de.essigt.adventofcode2020

import de.essigt.adventofcode2020.day5.BoardingPass

import scala.io.Source

/**
 * @author Tim Essig - essig@synyx.de
 */
object Day5 {

  def part1(filename : String) : Int = {
    loadInput(filename)
      .map(new BoardingPass(_))
      .map(_.calculateSeatId())
      .max
  }

  def part2(filename : String) : Option[Int] = {
    loadInput(filename)
      .map(new BoardingPass(_))
      .map(_.calculateSeatId())
      .sorted
      .sliding(2)
      .find(p => p.head+1 != p(1))
      .map(_.head+1)
  }


  private def loadInput(filename: String) : List[String] = {
    val file = Source.fromFile(filename)
    val lines = file.getLines().toList;
    file.close
    lines
  }

}

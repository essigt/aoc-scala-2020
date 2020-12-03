package de.essigt.adventofcode2020

import de.essigt.adventofcode2020.Day2.passwordPattern
import de.essigt.adventofcode2020.day3.TreeMap

import scala.io.Source

/**
 * @author Tim Essig - essig@synyx.de
 */
object Day3 {

  def part1(filename: String): Long = {
    val map = new TreeMap(loadInputPart(filename))
    map.findTreesOnRoute(3,1)
  }

  def part2(filename: String): Long = {
    val map = new TreeMap(loadInputPart(filename))

    val slope1 = map.findTreesOnRoute(1,1)
    val slope2 = map.findTreesOnRoute(3,1)
    val slope3 = map.findTreesOnRoute(5,1)
    val slope4 = map.findTreesOnRoute(7,1)
    val slope5 = map.findTreesOnRoute(1,2)

    slope1 * slope2 * slope3 * slope4 * slope5
  }

  private def loadInputPart(filename: String) = {

    val file = Source.fromFile(filename)
    val list = file.getLines
      .map(s => {
        s.split("", -1)
          .toList
          .filterNot(s => s.isEmpty)
      })
      .toList
    file.close
    list
  }

}

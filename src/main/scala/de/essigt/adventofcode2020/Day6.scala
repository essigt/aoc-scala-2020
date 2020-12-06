package de.essigt.adventofcode2020

import de.essigt.adventofcode2020.Day4.keyValuePattern
import de.essigt.adventofcode2020.day4.Passport

import scala.collection.immutable.HashSet
import scala.collection.mutable
import scala.io.Source

/**
 * @author Tim Essig - essig@synyx.de
 */
object Day6 {


  def part1(filename: String) : Int = {
    readInput1(filename).map(_.size).sum
  }

  def part2(filename: String) : Int = {
    readInput2(filename).map(_.size).sum
  }

  private def readInput1(filename: String) = {
    val groups = new mutable.Stack[Set[Char]]
    val file = Source.fromFile(filename)

    val lines = file.getLines();
    while (lines.hasNext) {
      val groupLines = lines.takeWhile(!_.isBlank).toList;
      val answers = groupLines
        .flatMap(_.toCharArray.toList)
        .toSet
      groups.push( answers)
    }
    file.close
    groups
  }


  private def readInput2(filename: String) = {
    val groups = new mutable.Stack[Set[Char]]
    val file = Source.fromFile(filename)

    val lines = file.getLines();
    while (lines.hasNext) {
      val groupLines = lines.takeWhile(!_.isBlank).toList;
      val answers = groupLines
        .map(_.toCharArray.toSet)
        .foldLeft(('a' to 'z').toSet)(_.intersect(_))
      groups.push( answers)
    }
    file.close
    groups
  }
}

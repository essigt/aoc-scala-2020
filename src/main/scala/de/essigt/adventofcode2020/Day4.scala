package de.essigt.adventofcode2020

import de.essigt.adventofcode2020.day4.Passport

import scala.collection.mutable
import scala.io.Source
import scala.util.matching.Regex

/**
 * @author Tim Essig - essig@synyx.de
 */
object Day4 {
  val keyValuePattern: Regex = "(\\w+):([a-zA-Z_0-9#]+)".r


  def part1(filename: String) : Int = {
    val passports = readInput(filename)
    passports.count(pp => pp.isValidPart1)
  }

  def part2(filename: String) : Int = {
    val passports = readInput(filename)
    passports.count(pp => pp.isValidPart2)
  }

  private def readInput(filename: String) = {
    val passports = new mutable.Stack[Passport]
    val file = Source.fromFile(filename)

    val lines = file.getLines();
    while (lines.hasNext) {
      val passportLines = lines.takeWhile(!_.isBlank).toList;
      val tuples = passportLines
        .flatMap(_.split(" ", -1)
          .toList
          .map( kv => {
            val matches = keyValuePattern.findAllIn(kv)
            (matches.group(1), matches.group(2))
          }))
        .toMap
      passports.push( new Passport(tuples))
    }
    file.close
    passports
  }

}

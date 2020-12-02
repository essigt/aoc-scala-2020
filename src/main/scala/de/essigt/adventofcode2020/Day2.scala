package de.essigt.adventofcode2020

import de.essigt.adventofcode2020.Day1.loadInput
import de.essigt.adventofcode2020.day2.{PasswordAndRulePairPart1, PasswordAndRulePairPart2}

import scala.io.Source
import scala.util.matching.Regex

/**
 * @author Tim Essig - essig@synyx.de
 */
object Day2 {
  val passwordPattern: Regex = "([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)".r

  def part1(filename: String): Int = {
    val rulePairs = loadInputPart1(filename)
    rulePairs.count(pair => pair.isValid)
  }

  def part2(filename: String): Int = {
    val rulePairs = loadInputPart2(filename)
    rulePairs.count(pair => pair.isValid)
  }

  private def loadInputPart1(filename: String) = {

    val file = Source.fromFile(filename)
    val list = file.getLines
      .map(s => {
        val matches = passwordPattern.findAllIn(s)
        val min = matches.group(1).toInt
        val max = matches.group(2).toInt
        val letter = matches.group(3).toCharArray()(0)
        val password = matches.group(4)

        new PasswordAndRulePairPart1(min, max, letter, password);
      })
      .toList
    file.close
    list
  }

  private def loadInputPart2(filename: String) = {

    val file = Source.fromFile(filename)
    val list = file.getLines
      .map(s => {
        val matches = passwordPattern.findAllIn(s)
        val first = matches.group(1).toInt
        val second = matches.group(2).toInt
        val letter = matches.group(3).toCharArray()(0)
        val password = matches.group(4)

        new PasswordAndRulePairPart2(first, second, letter, password);
      })
      .toList
    file.close
    list
  }

}

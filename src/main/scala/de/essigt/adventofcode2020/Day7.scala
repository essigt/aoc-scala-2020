package de.essigt.adventofcode2020

import de.essigt.adventofcode2020.day7.{Bag, LuggageRule}

import scala.collection.mutable
import scala.io.Source

/**
 * @author Tim Essig - essig@synyx.de
 */
object Day7 {

  private val surroundingBagRegex = "(\\w+ \\w+) bags".r
  private val containingBagRegex = "(\\d+) (\\w+ \\w+) bag[s]?".r

  def part1(filename : String) : Int = {
    val rules = readInput(filename)
    rules.count(containsShinyGoldenBag(_, rules))
  }

  def part2(filename : String) : Option[Int] = {
    val rules = readInput(filename)
    rules.find(e => e.surroundingBag.equals("shiny gold")).map(calculateContainingBags(_, rules))
  }

  private def containsShinyGoldenBag(r : LuggageRule, rules: List[LuggageRule]): Boolean = {
    if( r.containing.map(_.color).contains("shiny gold")) {
      return true
    }

    r.containing.exists( b => {
      rules.find(e => e.surroundingBag.equals(b.color)).exists(containsShinyGoldenBag(_, rules))
    })
  }

  private def calculateContainingBags(r : LuggageRule, rules: List[LuggageRule]): Int = {
    if( r.containing.isEmpty) {
      return 0
    }

    r.containing.map( b =>
      rules.find(e => e.surroundingBag.equals(b.color))
        .map(b.amount + b.amount * calculateContainingBags(_, rules))
        .getOrElse(0)
    ).sum
  }


  private def readInput(filename: String) = {
    val file = Source.fromFile(filename)

    val lines = file.getLines().map(l => {
      val splittedByContains = l.split("contain");
      val surroundingIterator = surroundingBagRegex.findAllIn(splittedByContains(0))
      val surrounding = surroundingIterator.group(1)

      if(splittedByContains(1).contains("no other")) {
        LuggageRule(surrounding, List[Bag]())
      } else {
        val bags = splittedByContains(1).split(",",-1)
          .map(containingBagRegex.findAllIn(_))
          .map(s => Bag(s.group(1).toInt, s.group(2)))
          .toList
        LuggageRule(surrounding, bags)
      }
    }).toList;
    file.close
    lines
  }
}

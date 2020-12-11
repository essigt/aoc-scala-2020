package de.essigt.adventofcode2020

/**
 * @author Tim Essig - essig@synyx.de
 */
class Day8Test extends org.scalatest.FunSuite {

  test("Day8.Part1") {
    assert(Day8.part1("src/test/resources/input_8.txt") === 1867)
  }

  test("Day8.Part2") {
    assert(Day8.part2("src/test/resources/input_8.txt") === Some(1303))
  }


}

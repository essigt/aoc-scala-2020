package de.essigt.adventofcode2020

/**
 * @author Tim Essig - essig@synyx.de
 */
class Day6Test extends org.scalatest.FunSuite {

  test("Day6.Part1") {
    assert(Day6.part1("src/test/resources/input_6.txt") === 6625)
  }

  test("Day6.Part2") {
    assert(Day6.part2("src/test/resources/input_6.txt") === 3360)
  }


}

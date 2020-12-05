package de.essigt.adventofcode2020

/**
 * @author Tim Essig - essig@synyx.de
 */
class Day5Test extends org.scalatest.FunSuite {

  test("Day5.Part1.test") {
    assert(Day5.part1("src/test/resources/input_5_test.txt") === 820)
  }

  test("Day5.Part1") {
    assert(Day5.part1("src/test/resources/input_5.txt") === 970)
  }

  test("Day5.Part2") {
    assert(Day5.part2("src/test/resources/input_5.txt") === Some(587))
  }


}

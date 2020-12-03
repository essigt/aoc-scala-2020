package de.essigt.adventofcode2020

/**
 * @author Tim Essig - essig@synyx.de
 */
class Day3Test extends org.scalatest.FunSuite {

  test("Day3.Part1") {
    assert(Day3.part1("src/test/resources/input_3_1.txt") === 252)
  }

  test("Day3.Part1.test") {
    assert(Day3.part1("src/test/resources/input_3_test.txt") === 7)
  }

  test("Day3.Part2") {
    assert(Day3.part2("src/test/resources/input_3_1.txt") === 2608962048L)
  }

  test("Day3.Part2.test") {
    assert(Day3.part2("src/test/resources/input_3_test.txt") === 336)
  }



}

package de.essigt.adventofcode2020

/**
 * @author Tim Essig - essig@synyx.de
 */
class Day10Test extends org.scalatest.FunSuite {

  test("Day10.Part1.test") {
    assert(Day10.part1("src/test/resources/input_10_test1.txt") === 220)
  }

  test("Day10.Part1") {
    assert(Day10.part1("src/test/resources/input_10.txt") === 2240)
  }

  test("Day10.Part2") {
    assert(Day10.part2("src/test/resources/input_10.txt") === 99214346656768L)
  }

  test("Day10.Part2.test2") {
    assert(Day10.part2("src/test/resources/input_10_test2.txt") === 8)
  }

  test("Day10.Part2.test1") {
    assert(Day10.part2("src/test/resources/input_10_test1.txt") === 19208)
  }

}

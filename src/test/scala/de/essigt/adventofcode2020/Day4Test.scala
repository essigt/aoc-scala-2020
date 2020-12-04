package de.essigt.adventofcode2020

/**
 * @author Tim Essig - essig@synyx.de
 */
class Day4Test extends org.scalatest.FunSuite {

  test("Day4.Part1.test") {
    assert(Day4.part1("src/test/resources/input_4_test.txt") === 2)
  }

  test("Day4.Part1") {
    assert(Day4.part1("src/test/resources/input_4_1.txt") === 170)
  }

  test("Day4.Part2.test_valid") {
    assert(Day4.part2("src/test/resources/input_4_2_valid.txt") === 4)
  }

  test("Day4.Part2.test_invalid") {
    assert(Day4.part2("src/test/resources/input_4_2_invalid.txt") === 0)
  }

  test("Day4.Part2") {
    assert(Day4.part2("src/test/resources/input_4_1.txt") === 103)
  }

}

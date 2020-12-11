package de.essigt.adventofcode2020

/**
 * @author Tim Essig - essig@synyx.de
 */
class Day7Test extends org.scalatest.FunSuite {

  test("Day7.Part1.test") {
    assert(Day7.part1("src/test/resources/input_7_test.txt") === 4)
  }

  test("Day7.Part1") {
    assert(Day7.part1("src/test/resources/input_7.txt") === 254)
  }

  test("Day7.Part2.test") {
    assert(Day7.part2("src/test/resources/input_7_test.txt") === Some(32))
  }

  test("Day7.Part2") {
    assert(Day7.part2("src/test/resources/input_7.txt") === Some(6006))
  }



}

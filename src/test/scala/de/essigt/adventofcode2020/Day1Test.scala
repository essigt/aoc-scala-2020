package de.essigt.adventofcode2020

/**
 * @author Tim Essig - essig@synyx.de
 */
class Day1Test extends org.scalatest.FunSuite {

    test("Day1.Part1") {
      assert(Day1.part1("src/test/resources/input_1_1.txt") === 539851)
    }


  test("Day1.Part2") {
    assert(Day1.part2("src/test/resources/input_1_1.txt") === 212481360)
  }



}

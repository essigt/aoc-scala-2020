package de.essigt.adventofcode2020

/**
 * @author Tim Essig - essig@synyx.de
 */
class Day9Test extends org.scalatest.FunSuite {

  test("Day9.Part1") {
    assert(Day9.part1("src/test/resources/input_9.txt", 25) === 26134589)
  }

  test("Day9.Part1.test") {
    assert(Day9.part1("src/test/resources/input_9_test.txt", 5) === 127)
  }

  test("Day9.Part2") {
    assert(Day9.part2("src/test/resources/input_9.txt", 25) === Some(3535124))
  }

  test("Day9.Part2.test") {
    assert(Day9.part2("src/test/resources/input_9_test.txt", 5) === Some(62))
  }


}

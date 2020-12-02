 package de.essigt.adventofcode2020

import scala.io.Source

/**
 * @author Tim Essig - essig@synyx.de
 */
object Day1 {

  def part1(filename: String): Int = {
    val numbers = loadInput(filename)

    for( number <- numbers ) {
      val missingValue = 2020 - number

      if( numbers contains missingValue ) {
        number * missingValue
      }
    }

    -1
  }


  def part2(filename: String): Int = {
    val numbers = loadInput(filename);

    for(number1 <- numbers) {
      for(number2 <- numbers) {
        for(number3 <- numbers) {
          val sum = number1 + number2 + number3

          if(sum == 2020) {
            number1 * number2 * number3
          }
        }
      }
    }

    -1;
  }

  private def loadInput(filename: String) = {
    val file = Source.fromFile(filename)
    val list = file.getLines
      .map(s => s.toIntOption)
      .filter(i => i.isDefined)
      .map(i => i.get).toList
    file.close
    list
  }
}

package de.essigt.adventofcode2020.day5

/**
 * @author Tim Essig - essig@synyx.de
 */
class BoardingPass(code: String) {

  val rows = 128
  val seats = 8

  private val row = calculateRow(code)
  private val seat = calculateSeat(code)

  def calculateSeatId() : Int = {
    row * seats + seat;
  }

  private def calculateRow(code : String) : Int = {
    var range = 0 until rows

    for(pos <- 0 to 6) {
      val splitted = splitRangeInHalf(range)
      range = if (code.charAt(pos) == 'F')  splitted._1 else splitted._2
    }

    range.start
  }

  private def calculateSeat(code : String) : Int = {
    var range = 0 until seats

    for(pos <- 7 to 9) {
      val splitted = splitRangeInHalf(range)
      range = if (code.charAt(pos) == 'L')  splitted._1 else splitted._2
    }

    range.start
  }

  private def splitRangeInHalf(range: Range) = {
    range.splitAt(range.length / 2)
  }



}

package de.essigt.adventofcode2020.day3

/**
 * @author Tim Essig - essig@synyx.de
 */
class TreeMap(map: List[List[String]]) {

  def findTreesOnRoute(slopeX: Int, slopeY: Int): Long= {
    var x = slopeX
    var y = slopeY
    var trees = 0

    while(y < getYMax) {
      if( getAtPosition(x,y).equals("#")) {
        trees += 1
      }

      x += slopeX
      y += slopeY
    }
    trees
  }

  private def getAtPosition(x: Int, y:Int) : String = {
    val segmentWidth = map(0).length
    val xOffset = x % segmentWidth ;
    map(y)(xOffset)
  }

  private def getYMax() : Int = {
    map.length
  }
}

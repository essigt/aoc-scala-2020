package de.essigt.adventofcode2020.day8

import scala.collection.mutable

/**
 * @author Tim Essig - essig@synyx.de
 */
class InterpreterPart2(instructions: List[Instruction]) {

  private var accumulator = 0
  private var ip = 0


  def runAndReturnAccumulator() : Option[Int] = {
    val alreadyVisitedInstructions = new mutable.HashSet[Int]()

    while(ip < instructions.length) {
      val instruction = instructions(ip)

      if(alreadyVisitedInstructions.contains(ip)) {
        return None
      } else
        alreadyVisitedInstructions.add(ip)

      instruction match {
        case Add(value) => add(value)
        case Jump(value) => jmp(value)
        case NoOp(_) => nop()
      }
    }

    Some(accumulator)
  }



  private def add(value: Int): Unit = {
    accumulator += value
    ip+=1
  }

  private def jmp(value: Int): Unit = {
    ip+=value
  }

  private def nop(): Unit = {
    ip+=1
  }


}

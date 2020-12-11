package de.essigt.adventofcode2020

import de.essigt.adventofcode2020.day8.{Add, Instruction, InterpreterPart1, InterpreterPart2, Jump, NoOp}

import scala.io.Source

/**
 * @author Tim Essig - essig@synyx.de
 */
object Day8 {

  def part1(filename: String) : Int = {
    val instructions = loadInput(filename)
    new InterpreterPart1(instructions).runAndReturnAccumulator()
  }

  def part2(filename: String) : Option[Int] = {
    val instructions = loadInput(filename)

    for(changeInstruction <- instructions.indices) {
      val changedInstructions = instructions.map(el => {
        if(instructions.indexOf(el) == changeInstruction) switchInstruction(el) else el
      })

      val inter = new InterpreterPart2(changedInstructions)
      val acc = inter.runAndReturnAccumulator()
      if(acc.isDefined) {
        return acc
      }
    }

    None
  }

  def switchInstruction(el: Instruction): Instruction = {
    el match
    {
      case Jump(value) => NoOp(value)
      case NoOp(value) => Jump(value)
      case Add(value) => Add(value)
    }
  }

  private def loadInput(filename : String): List[Instruction] = {
    val file = Source.fromFile(filename)

    val instructions = file.getLines().map {
      case s"acc $value" => Add(value.toInt)
      case s"jmp $value" => Jump(value.toInt)
      case s"nop $value" => NoOp(value.toInt)
    }.toList

    file.close()
    instructions
  }

}

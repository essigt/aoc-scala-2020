package de.essigt.adventofcode2020.day8

/**
 * @author Tim Essig - essig@synyx.de
 */
trait Instruction {
}

case class Add(value: Int) extends Instruction
case class Jump( value: Int) extends Instruction
case class NoOp( value: Int) extends Instruction

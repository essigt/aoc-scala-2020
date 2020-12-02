package de.essigt.adventofcode2020.day2

/**
 * @author Tim Essig - essig@synyx.de
 */
class PasswordAndRulePairPart1(min: Int, max: Int, letter: Char, password: String) {

  def isValid: Boolean = {
    val amount = password.count(c => c.equals(letter))
    min <= amount && amount <= max
  }
  override def toString() = min + "-" + max + " " + letter + ": " + password + " valid: " + isValid
}

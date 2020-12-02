package de.essigt.adventofcode2020.day2

/**
 * @author Tim Essig - essig@synyx.de
 */
class PasswordAndRulePairPart2(firstPosition: Int, secondPosition: Int, letter: Char, password: String) {

  def isValid: Boolean = {
    password.charAt(firstPosition-1) == letter ^ password.charAt(secondPosition-1)== letter
  }
  override def toString = firstPosition + "-" + secondPosition + " " + letter + ": " + password + " valid: " + isValid
}

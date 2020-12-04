package de.essigt.adventofcode2020.day4

import scala.collection.mutable
import scala.util.matching.Regex



/**
 * @author Tim Essig - essig@synyx.de
 */
class Passport(fields: Map[String, String]) {
  val colorPattern: Regex = "(#[0-9a-f]+)".r
  val pidPattern: Regex = "([0-9]{9})".r

  def isValidPart1 : Boolean = {
    fields.contains("byr") &&
    fields.contains("iyr") &&
    fields.contains("eyr") &&
    fields.contains("hgt") &&
    fields.contains("hcl") &&
    fields.contains("ecl") &&
    fields.contains("pid")
  }


  def isValidPart2 : Boolean = {
    byrValid() &&
      iyrValid() &&
      eyrValid() &&
      hgtValid &&
      hclValid() &&
      eclValid &&
      pidValid()
  }

  private def byrValid() : Boolean = {
    try {
      fields.get("byr")
        .map(_.toInt)
        .exists(y => (y >= 1920 && y <= 2002))
    } catch {
      case e: Exception => false
    }
  }


  private def iyrValid() : Boolean = {
    try {
      fields.get("iyr")
        .map(_.toInt)
        .exists(y => (y >= 2010 && y <= 2020) )
    } catch {
      case e: Exception => false
    }
  }

  private def eyrValid() : Boolean = {
    try {
      fields.get("eyr")
        .map(_.toInt)
        .exists(y => (y >= 2020 && y <= 2030))
    } catch {
      case e: Exception => false
    }
  }


  private def hclValid() : Boolean = {
    try {
      fields.get("hcl")
        .exists(colorPattern.matches(_))
    } catch {
      case e: Exception => false
    }
  }

  private def eclValid() : Boolean = {
    val colors = List("amb", "blu","brn", "gry", "grn" ,"hzl" ,"oth")
    try {
      fields.get("ecl")
        .exists(colors.contains(_))
    } catch {
      case e: Exception => false
    }
  }

  private def hgtValid() : Boolean = {
    try {
      val hgtOptional = fields.get("hgt");
      if(hgtOptional.isEmpty) {
        false
      } else {
        hgtOptional.get match {
          case s"${cm}cm" => (150 to 193 contains cm.toInt)
          case s"${in}in" => ( 59 to  76 contains in.toInt)
          case _ => false
        }
      }
    } catch {
      case e: Exception => false
    }
  }

  private def pidValid() : Boolean = {
    try {
      fields.get("pid")
        .exists(pidPattern.matches(_))
    } catch {
      case e: Exception => false
    }
  }
}

package day_2

import scala.util.Random

object patternmatching {
  // ==== Pattern Matching ====
  // 1. Write a function that uses pattern matching to convert the Ints 0 - 4
  //    in to String representation e.g. 1 -> "one"
  Random.nextInt(4) match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case 4 => "four"
  }

  // ==== Multiple Matches ====
  // 2. Write a function that takes a command String. If the command is "start"
  //    or "START" then return 1 else if it's "stop" or "STOP" return 0.
  val command = "start"
  command match {
    case "stop" | "STOP" => 0
    case "start" | "START" => 1
  }

  // ==== Guards ====
  // 2. Using pattern matching with a guards write a function that takes an Int
  //    and returns the String "even" if the number is even and "odd" otherwise.
  def evenOdd(num: Int): String = num match {
    case i if i % 2 == 0 => "even"
    case _ => "odd"
  }

  // ==== Case Classes ====
  // 1. Create a case class for a film Director with a name and nationality.
  case class Director(name: String, nationality: String)

  // 2. Create a case class for a Film with a name and director.
  case class Film(name: String, director: Director)

  // 3. Write a function using pattern matching that takes a Film and return
  //    the films name and who directed it in a String.
  def getDirector(film: Film): String = film match {
    case Film(filmName, Director(directorName, _)) => s"$filmName - directed by $directorName"
  }

  //  4. Write a function using pattern matching that takes a Film and returns
  //     the nationality of the director.
  def getDirectorNationality(film: Film): String = film match {
    case Film(_, Director(_, nationality)) => nationality
  }

  // ==== Lists ====
  // 1. Create a case class for a Person with a name.
  case class Person(name: String)

  // 2. Write a function that takes a list of people and a name and returns true
  //    if any of the people have that name.
  def find(people: List[Person], name: String): Boolean = {
    people match {
      case Person(n) :: Nil => n == name
      case Person(n) :: remaining => if(n == name) true else find(remaining, name)
    }
  }
  val peeps = List(Person("Sarah"), Person("Oli"), Person("Astrid"))
  find(peeps, "Sarah")
}

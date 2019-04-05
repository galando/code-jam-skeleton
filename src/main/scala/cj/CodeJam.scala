package cj

import java.io._

import scala.annotation.tailrec
import scala.io.Source

object CodeJam {

  val LOC = "./src/main/resources/"
  val DEFAULT_ARGS = "sub-1"

  def main(args: Array[String]) = {
    val inputFile = Source.fromFile(s"$LOC${args.headOption.getOrElse(DEFAULT_ARGS)}.in")
    val outputFile = new PrintWriter(s"$LOC${args.headOption.getOrElse(DEFAULT_ARGS)}.out")
    val sourceFilesLines = inputFile.getLines()

    val numberOfCases: Int = Integer.valueOf(sourceFilesLines.next())

    for (caseNum <- 1 to numberOfCases) {
      val result = solve(sourceFilesLines)
      outputFile.write(s"Case #$caseNum: $result\n")
      System.out.println(s"Case #$caseNum: $result")
    }

    outputFile.flush()
    outputFile.close()
  }

  val HAPPY = '+'
  val SAD = '-'
  val IMPOSSIBLE = "IMPOSSIBLE"

  def solve(sourceFilesLines : Iterator[String]): String = {
    val input = sourceFilesLines.next().split(" ")
    val str = input.head
    val k = input.last.toInt

    val result = flipRec(str.toList, k, 0)
    if (result == -1) IMPOSSIBLE else result.toString
  }

  @tailrec
  def flipRec (str: List[Char], k: Int, retries: Int) : Int = {
    if (allHappy(str)) {
      retries
    } else {
      flip(str, k) match {
        case (newStr, true) if allHappy(str) =>
          if (str == newStr) retries else retries + 1
        case (newStr, true) =>
          flipRec(newStr, k, retries + 1)
        case (_, false) => -1
      }
    }
  }

  def allHappy (str: List[Char]) : Boolean = str.forall(_ == HAPPY)

  def flip(str: List[Char], k: Int) : (List[Char], Boolean) = {
    val firstSadO = str.find(_ == SAD)
    firstSadO.fold {
      (str, true)
    }{
      firstSad =>
        val indexOfFirstSad = str.indexOf(firstSad)
        if (indexOfFirstSad <= (str.size - k)) {
          val (beforeFlip, afterFlip) = str.splitAt(indexOfFirstSad)
          val flipped = afterFlip.take(k).map(ch => if (ch == HAPPY) SAD else HAPPY)

          (beforeFlip ++ flipped ++ afterFlip.drop(k), true)
        } else {
          (str, false)
        }
    }
  }
}

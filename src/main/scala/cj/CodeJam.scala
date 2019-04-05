package cj

import java.io._
import scala.io.Source

object CodeJam {

  val LOC = "./src/main/resources/"

  def main(args: Array[String]) = {
    val inputFile = Source.fromFile(s"$LOC${args(0)}.in")
    val outputFile = new PrintWriter(s"$LOC${args(0)}.out")
    val sourceFilesLines = inputFile.getLines()

    val numberOfCases: Int = Integer.valueOf(sourceFilesLines.next())

    for (caseNum <- 1 to numberOfCases) {
      val result = solve(sourceFilesLines)
      outputFile.write(s"Case #$caseNum: $result\n")
      System.out.println(s"Case #$caseNum: $result")
    }
  }

  def solve(sourceFilesLines : Iterator[String]): String = ???
}

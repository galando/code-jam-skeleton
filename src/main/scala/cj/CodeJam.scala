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
}

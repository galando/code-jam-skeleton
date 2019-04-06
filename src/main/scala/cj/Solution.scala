package cj

object Solution {

  def main(args: Array[String]) = {
    val numberOfCases: Int = scala.io.StdIn.readInt()

    for (caseNum <- 1 to numberOfCases) {
      val result = solve(scala.io.StdIn.readLine())
      System.out.println(s"Case #$caseNum: $result")
    }
  }

  def solve(sourceLine: String): String = ???
}

package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      def pascalIter(c: Int, r: Int, acc: => Int): Int = {
        if (c == 0 || r == 0 || r == c) acc
        else pascalIter(c-1, r-1, acc) + pascalIter(c, r-1, acc)
      }
      pascalIter(c, r, 1)
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def isOpenParen(char: Char): Boolean =
        char == '('

      def isCloseParen(char: Char): Boolean =
        char == ')'

      def getNewCount(char: Char, count: => Int): Int = {
        var newCount = count
        if (isOpenParen(char)) newCount += 1
        else if (isCloseParen(char)) newCount -= 1
        newCount
      }

      def balanceIter(chars: List[Char], char: Char, count: Int): Boolean = {
        val newCount = getNewCount(char, count)
        if (chars.isEmpty || newCount < 0) newCount == 0
        else balanceIter(chars.tail, chars.head, newCount)
      }

      balanceIter(chars.tail, chars.head, 0)
    }

    /**
     * Exercise 3
     */
      def countChange(money: Int, coins: List[Int]): Int = {
        def countChangeIter(money: Int, coins: List[Int], acc: Int): Int = {
          var newAcc = acc
          if (!coins.isEmpty && money > 0) {
            val coin = coins.head
            if (money - coin == 0) {
              newAcc += 1
            } else if (coins.head > 0) {
              newAcc += countChangeIter(money - coin, coins, acc)
              newAcc += countChangeIter(money, coins.tail, acc)
            }
          }
          newAcc
        }
        countChangeIter(money, coins.sorted, 0)
      }
  }

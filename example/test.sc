//def factorial(x: Int): Int = {
//  def loop(x: Int, acc: Int): Int = {
//    if (x == 0) acc
//    else loop(x - 1, x * acc)
//  }
//  loop(x, 1)
//}
//
//factorial(4)

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

countChange(300,List(500,5,50,100,20,200,10))

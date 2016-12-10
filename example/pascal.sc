def pascal(c: Int, r: Int): Int = {
  def pascalIter(c: Int, r: Int, acc: => Int): Int = {
    if (c == 0 || r == 0 || r == c) acc
    else pascalIter(c-1, r-1, acc) + pascalIter(c, r-1, acc)
  }
  pascalIter(c, r, 1)
}

println("Pascal's Triangle")
for (row <- 0 to 10) {
  for (col <- 0 to row)
    print(pascal(col, row) + " ")
  println()
}


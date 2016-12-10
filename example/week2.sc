def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
}

def sum(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 0
  else f(a) + sum(f)(a + 1, b)
}

def product(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 1
  else f(a) * product(f)(a + 1, b)
}

def factorial(x: Int): Int = {
  product(x => x)(1, x)
}

mapReduce(x => x, (a, b) => a + b, 0)(1, 4)
sum(x => x)(1, 4)
mapReduce(x => x * x, (a, b) => a + b, 0)(1, 4)
sum(x => x * x)(1, 4)
mapReduce(x => x * x, (a, b) => a * b, 1)(3, 4)
product(x => x * x)(3, 4)
factorial(4)

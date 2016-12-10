const _ = require('lodash');

function balance(chars) {
  const isClosingParen = (char) => {
    return char == ')'
  }
  const isOpeningParen = (char) => {
    return char == '('
  }
  const balanceIter = (chars, char, count) => {
    if (isOpeningParen(char)) {
      count++;
    } else if (isClosingParen(char)) {
      count--;
    }
    if (!_.size(chars) || count < 0) {
      return count
    } else {
      return balanceIter(_.tail(chars), _.head(chars), count);
    }

  }
  return balanceIter(_.tail(chars), _.head(chars), 0) === 0
}

const balanceTest1 = "if (zero? x) max (/ 1 x)".split('')
console.log(balance(balanceTest1))
const balanceTest2 = "I told him (that it’s not (yet) done). (But he wasn’t listening)".split('')
console.log(balance(balanceTest2))
const balanceTest3 = ":-)".split('')
console.log(balance(balanceTest3))
const balanceTest4 = "())(".split('')
console.log(balance(balanceTest4))

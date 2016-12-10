const _ = require('lodash');

function countChange(money, coins) {
  // const fitEvently = (money, coin) => {
  //   return ()
  // }

  const countChangeIter = (money, coins) => {
    if (!coins.length || _.head(coins) < 0) return result
    let coin = _.head(coins)
    if (money - coin == 0) {
      result++
    } else if(money - coin > 0) {
      result = countChangeIter(money - coin, coins);
      result = countChangeIter(money, _.tail(coins));
    }
    return result
  }

  let result = 0;
  countChangeIter(money, coins)

  return result;
}

console.log(countChange(4, [1, 2]))



// function countChange(money, coins) {
//   const fitEvently = (money, coin) => {
//     return (money - coin === 0)
//   }
//
//   const countChangeIter = (money, coins, result) => {
//     for (var i = 0; i < coins.length; i++) {
//       let coin = coins[i];
//       if (fitEvently(money, coin)) {
//         result++
//       } else if(money - coin > 0) {
//         result = countChangeIter(money - coin, coins, result);
//       }
//     }
//     return result
//   }
//
//   return countChangeIter(4, [1, 2], 0)
// }

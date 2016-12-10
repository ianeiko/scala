// def main(args: Array[String]) {
//   println("Pascal's Triangle")
//   for (row <- 0 to 10) {
//     for (col <- 0 to row)
//       print(pascal(col, row) + " ")
//     println()
//   }
// }
// def pascal(c: Int, r: Int): Int = {
//   1
// }


function pascal(c, r) {
  if (c === 0 || r === 0 || c === r) {
    return 1;
  } else {
    return pascal(c-1, r-1) + pascal(c, r-1);
  }
}

for (var row = 0; row <= 10; row++) {
  let result = '';
  for (var col = 0; col <= row; col++) {
    result += pascal(col, row) + " ";
  }
  console.log(result);
}

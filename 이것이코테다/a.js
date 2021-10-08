const string = "abcababcabab";
const regex = /(?:ab){1,3}(?!c)/ig
const result = string.match(regex);

console.log(result);
function solution(expression) {
    var answer = 0;
    
    let expressionArr = ["+", "-", "*"];
    let answerArr = [];
    
    let num = expression.replace(/[^0-9]/g,' ');
    let cal = expression.replace(/[0-9]/g,'');
    num = num.split(' ');
    cal = cal.split('');
    
    expressionArr = permutation(expressionArr, 3);
    
    expressionArr.forEach((arr)=>{
        // console.log(arr);
        let numTemp = num.slice();
        let calTemp = cal.slice();
        
        arr.forEach((ex)=>{
            for (let i = 0; i < calTemp.length; i++) {
                if (calTemp[i] === ex) {
                    numTemp[i] = (calTemp[i] === '+') ? Number(numTemp[i]) + Number(numTemp[i+1]) : 
                    (calTemp[i] === '-') ? numTemp[i] - numTemp[i+1] : numTemp[i] * numTemp[i+1];
                    
                    numTemp.splice(i+1, 1);
                    calTemp.splice(i, 1);
                    
                    i -= 1;
                }
            }
        })
        
        answerArr.push(Math.abs(numTemp[0]));
        // console.log(numTemp);
    })
    
    return answer = Math.max(...answerArr);
}

function permutation(arr, selectNum) {
  let result = [];
  if (selectNum === 1) return arr.map((v) => [v]);

  arr.forEach((v, idx, arr) => {
    const fixer = v;
    const restArr = arr.filter((_, index) => index !== idx);
    const permuationArr = permutation(restArr, selectNum - 1);
    const combineFixer = permuationArr.map((v) => [fixer, ...v]);
    result.push(...combineFixer);
  });
  return result;
}
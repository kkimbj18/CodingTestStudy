// const removeOne = (number, k) => {
//     let index = 0;
//     for(let j = 0; j < k; j++){
//         index = number.length-1;
//         for(let i = 0; i < index; i++) {
//             if(number[i] < number[i+1]) {
//                 index = i;
//                 break;
//             }
//         }
//         number = number.slice(0, index) + number.slice(index+1);
//     }
    
//     return number;
// }

// function solution(number, k) {
//     const answer = removeOne(number, k);
    
//     return answer;
// }

function solution(number, k) {
    const len = number.length;
    let answer = [];
    let base = 9;
    let count = 0;
    
    loop1:
    for(let i = 0; i < len; i++) {
        if(base < number[i]) {
            while(1){
                if(number[i] > answer[answer.length-1]) {
                    answer.pop();
                    count++;
                    if(count === k) {
                        answer = answer.concat(number.slice(i).split(""));
                        break loop1;
                    }
                }
                else break;
            }
        }
        answer.push(number[i]);
        base = number[i];
    }
    if(count != k)
        answer.splice(count-k);
    
    return answer.join('');
}
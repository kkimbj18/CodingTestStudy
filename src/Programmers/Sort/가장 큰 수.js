// function solution(numbers) {
//     var answer = '';
    
//     numbers.sort((a,b)=>{
//         let first = a;
//         let second = b;
//         while(1) {
//             if(first>=10) first/=10;
//             else if(second>=10) second/=10;
//             else break;
//         }
//         return second-first;
//     });
    
//     answer = numbers.join("");
    
//     return answer;
// }

function solution(numbers) {
    var answer = '';
    
    answer = numbers.map(x=>''+x).sort((a,b)=>{
        return (b+a)-(a+b);
    });
    
    answer = (answer[0] === '0') ? '0' : answer.join("");
    
    return answer;
}
// function solution(people, limit) {
//     var answer = 0;
//     let count = 0;
    
//     let arr = [];
    
//     people.sort((a,b)=>b-a);
    
//     people.forEach((value, idx)=>{
//         const result = arr.some((v, i)=>{
//             if(v - value >= 0) {
//                 arr.pop(i);
//                 count++;
//                 return true;
//             }
//         });
//         if(!result) {
//             const rest = limit - value;
//             if(rest < 40) {
//                 count++;
//             }
//             else {
//                 arr.push(rest);
//             }
//         }
//         // console.log(arr);
//     })
    
//     answer = arr.length + count;
    
//     return answer;
// }

function solution(people, limit) {
    var answer = 0;
    let count = 0;
    
    const lastIndex = people.length - 1;
    let idxBack = lastIndex;
    
    people.sort((a,b)=>b-a);
    
    people.some((value, idx, array)=>{
        // console.log(array[idx], array[idxBack], limit);
        if(idx >= idxBack) return true;
        if(array[idx] + array[idxBack] <= limit) {
            count++;
            idxBack--;
        }
    });
    
    count += (lastIndex % 2 === 1) ? ((lastIndex + 1) / 2 - count) * 2 : (lastIndex / 2 - count) * 2 + 1;
    
    return answer = count;
}
// function solution(gems) {
//     var answer = [];
    
//     const gemList = new Set([...gems]);
//     const gemLen = gemList.size;
//     let set = new Set();
//     let scopeArr = [];
//     let minDiff = Number.MAX_SAFE_INTEGER;
//     let index = 0;
//     let prev = 0;
    
//     gems.forEach((gem, idx)=>{
//         set.add(gem);
        
//         if (set.size === gemLen) {
//             set.clear();
//             scopeArr.push([prev+1, idx+1]);
//             prev = idx+1;
//         }
//     });
    
//     scopeArr.forEach((scope, idx)=>{
//         set.clear();
        
//         for (let i = scope[1]-1; i >= scope[0]-1; i--) {
//             set.add(gems[i]);
            
//             if (set.size === gemLen) {
//                 scope[0] = i+1;
//                 let diff = scope[1] - scope[0];
//                 if (minDiff > diff) {
//                     minDiff = diff;
//                     index = idx;
//                 }
//                 break;
//             }
//         }
//     })
    
//     answer = scopeArr[index];
    
//     return answer;
// }

function solution(gems) {
    var answer = [];
    
    const gemList = new Set([...gems]);
    const gemLen = gemList.size;
    let temp;
    let len = gemLen;
    let isFound;
    
    while(1) {
        temp = [];
        
        gems.some((gem, idx)=>{
            isFound = true;
            
            if (temp.length === len) temp.shift();
            temp.push(gem);
            
            Array.from(gemList).some((g)=>{
                if (!temp.includes(g)) {
                    isFound = false;
                    return true;
                }
            });

            if (isFound) {
                answer = [idx-len+2, idx+1];
                
                return true;
            }
        })
        
        if (isFound) break;
        
        len++;
    }
    
    return answer;
}
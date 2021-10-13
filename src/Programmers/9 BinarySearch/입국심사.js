// function solution(tickets) {
//     var answer = new Array(tickets.length+1).fill("ZZZ");
    
//     dfs(tickets, ["ICN"]);
    
//     function dfs(rest, route) {
//         if (rest.length === 0) {
//             if (answer > route)
//                 answer = route;
//         }
        
//         rest.forEach((v, i)=>{
//             if (v[0] === route[route.length-1]) {
//                 let restTemp = [...rest];
//                 let routeTemp = [...route];
//                 routeTemp.push(v[1]);
//                 restTemp.splice(i, 1);
//                 dfs(restTemp, routeTemp);
//             }
//         });
//     }
    
//     return answer;
// }

function solution(n, times) {
    var answer = 0;
    
    times.sort((a,b)=>a-b);
    
    let right = n * times[times.length - 1];
    let left = 1;
    let middle;
    let cnt;
    let possibleAnswer = [];
    
    while (left <= right) {
        middle = Math.floor((left + right)/2);
        
        cnt = times.reduce((acc, t)=>{
            return acc += Math.floor(middle/t);
        }, 0);
        
        if (cnt >= n) {
            possibleAnswer.push(middle);
            right = middle - 1;
        }
        else left = middle + 1;
    }
    
    answer = Math.min(...possibleAnswer);
    
    return answer;
}
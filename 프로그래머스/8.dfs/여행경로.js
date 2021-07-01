function solution(tickets) {
    var answer = new Array(tickets.length+1).fill("ZZZ");
    
    dfs(tickets, ["ICN"]);
    
    function dfs(rest, route) {
        if (rest.length === 0) {
            if (answer > route)
                answer = route;
        }
        
        rest.forEach((v, i)=>{
            if (v[0] === route[route.length-1]) {
                let restTemp = [...rest];
                let routeTemp = [...route];
                routeTemp.push(v[1]);
                restTemp.splice(i, 1);
                dfs(restTemp, routeTemp);
            }
        });
    }
    
    return answer;
}
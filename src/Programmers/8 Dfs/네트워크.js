function solution(n, computers) {
    var answer = 0;
    let visited = new Array(n).fill(0);
    let network = [];
    let temp = [];
    
    computers.forEach((com, idx)=>{
        temp = [];
        
        if (dfs(com, idx) === 1) {
            network.push(temp);
        }
    });
    
    function dfs(computer, index) {
        if (visited[index] === 1) return 0;
        
        temp.push(index);
        visited[index] = 1;
        
        computer.some((c, i)=>{
            if (i === index) return false;
            
            if (c === 1) {
                dfs(computers[i], i);
            }
        });
        
        return 1;
    }
    
    return answer = network.length;
}
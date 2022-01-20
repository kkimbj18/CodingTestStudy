function solution(n, edge) {
    var answer = 0;
    
    edge = edge.map((e)=>{
        return (e[0]>e[1]) ? [e[1]-1,e[0]-1] : [e[0]-1,e[1]-1];
    });
    
    const table = Array.from(Array(n), ()=>Array(n).fill(0));
    
    edge.forEach((e)=>{
        table[e[0]][e[1]] = 1;
    });
    
    const arr = new Set([0]);
    let prev = [0];
    let next = [];
    
    while(1) {
        if (arr.size >= n) break;
        
        prev.forEach((a)=>{
            table[a].forEach((b, i)=>{
                if (b === 1 && !arr.has(i)) {
                    arr.add(i);
                    next.push(i);
                }
            });
        });
        
        prev = next;
        next = [];
    }
    
    answer = prev.length;
    
    return answer;
}
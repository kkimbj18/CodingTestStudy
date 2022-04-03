function solution(operations) {
    var answer = [];
    let operation = [];
    let heap = [];
    
    for (let i in operations) {
        operation = operations[i].split(" ");
        if(operation[0].includes("I")){
            heap.push(operation[1]);
        }
        else {
            if(heap.length == 0) continue;
            
            heap.sort((a,b)=>{
                return b - a;
            });
            
            (operation[1]==1) ? heap.shift() : heap.pop();
        }
    }
    
    heap.sort((a,b)=>{
        return b - a;
    })
    
    answer[0] = Number(heap.shift() || 0);
    answer[1] = Number(heap.pop() || 0);
    
    return answer;
}
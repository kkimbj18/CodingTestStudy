function solution(distance, rocks, n) {
    rocks.sort((a,b)=>a-b);
    rocks = [...rocks, distance];
    
    var answer = 0;
    
    let left = 0;
    let right = distance;
    let mid;
    let from;
    let count;
    
    while (left <= right) {
        mid = Math.floor((left+right)/2);
        
        from = 0;
        count = 0;
        
        rocks.some((rock)=>{
            if (rock - from < mid) count++;
            else from = rock;
        });
        
        if (count > n) right = mid - 1;
        else {
            answer = Math.max(answer, mid);
            
            left = mid + 1;
        } 
    }
    
    return answer;
}
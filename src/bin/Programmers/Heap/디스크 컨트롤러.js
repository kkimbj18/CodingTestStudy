function solution(jobs) {
    var answer = 0;
    let time = 0;
    let waiting = [];
    let len = jobs.length;
    let index = 0;
    
    jobs.sort((a,b)=>{
        return a[0] - b[0];
    })
    
    loop1:
    while(1){
        while(1){
            if(jobs.length==0){
                if(waiting.length==0)
                    break loop1;
                break;
            }
            
            if(jobs[0][0] <= time){
                waiting.push(jobs.shift());
            }
            else {
                if(waiting.length==0){
                    time = jobs[0][0];
                    continue loop1;
                }
                break;
            }
        }
        
        waiting.sort((a,b)=>{
            return a[1] - b[1];
        })
        
        answer += time - waiting[0][0] + waiting[0][1];
        time += waiting.shift()[1];
    }
    
    answer /= len
    
    return parseInt(answer);
}
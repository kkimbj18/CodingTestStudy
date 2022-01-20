function solution(citations) {
    var answer = 0;
    let idx = 0;
    let i;
    
    citations.sort((a,b)=>b-a);
    
    loop1:
    for(i=1; i<=citations.length; i++) {
        idx = 0;
        while(1) {
            if(citations[idx] >= i) {
                if(++idx === i) break;
            }
            else break loop1;
        }
    }
    
    return answer = i-1;
}
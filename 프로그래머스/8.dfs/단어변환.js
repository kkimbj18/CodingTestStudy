function solution(begin, target, words) {
    var answer = Number.MAX_SAFE_INTEGER;
    
    conv(begin, 0, []);
    
    if (answer === Number.MAX_SAFE_INTEGER)
        answer = 0;
    
    function isAbleToConv(count) {
        return (count === begin.length - 1) ? true : false;
    }
    function conv(prev, phase, arr) {
        if (arr.includes(prev)) return;
        if (prev===target) {
            console.log(prev);
            answer = (phase < answer) ? phase : answer;
            
            return;
        }
        
        arr.push(prev);
        
        words.forEach((w)=>{
            const match_count = Array.from(w).reduce((sum, val, idx)=>{
                if (val == prev.charAt(idx)) sum++;
                
                return sum;
            }, 0);
            
            if (isAbleToConv(match_count)) {
                conv(w, phase+1, arr);
            }
        });
        
        return;
    }
    
    return answer;
}
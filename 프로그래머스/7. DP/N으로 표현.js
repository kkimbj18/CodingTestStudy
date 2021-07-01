function solution(N, number) {
    var answer = -1;
    let dp = [];
    let str = "";
    
    for(let i = 1; i <= 8; i++) {
        const numbers = new Set();
        
        str += String(N);
        numbers.add(Number(str));
        
        for(let j = 0; j < i-1; j++) {
            dp[j].forEach((v)=>{
                dp[i-j-2].forEach((value)=>{
                    numbers.add(v + value);
                    numbers.add(v * value);
                    numbers.add(v - value);
                    
                    if(value != 0) numbers.add(Math.floor(v / value));
                })
            });
        }
        
        if(numbers.has(number)) {
            answer = i;
            break;
        }
        
        dp.push(numbers);
    }
    
    
    return answer;
}
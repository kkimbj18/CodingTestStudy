function solution(numbers, target) {
    var answer = 0;
    
    findTarget(0, 0);
    
    function findTarget(count, sum) {
        if (count === numbers.length) {
            if (sum === target) answer++;
            
            return
        }
        
        findTarget(count+1, sum+numbers[count]);
        findTarget(count+1, sum-numbers[count]);
    }
    
    return answer;
}
function solution(brown, yellow) {
    var answer = [];
    
    for(let i = 3; i < brown/2; i++) {
        for(let j = 3; j <= i; j++) {
            if(brown === 2 * (i + j - 2)) {
                if(yellow === ((i-2) * (j-2))) {
                    answer.push(i);
                    answer.push(j);
                }
            }
        }
    }

    return answer;
}
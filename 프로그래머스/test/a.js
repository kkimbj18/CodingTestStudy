function solution(n) {
    var answer = [];
    let tempArray = Array.from(Array(1000), () => new Array(1000));
    let count = 0;
    let phase = 0;

    for (let i = 0; i < n; i++) {
        for(let j = n-i; j > 0; j--) {
            count++;
            phase = parseInt(i/3);
            if(i % 3 === 0) {
                tempArray[phase][n-j-phase] = count;
            }
            else if(i % 3 === 1) {
                tempArray[n-i-(j-1)+phase][n-phase-1] = count;
            }
            else if(i % 3 === 2) {
                tempArray[i+j-2-phase-phase][i+j-2-phase] = count;
            }
        }
    }

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i+1; j++) {
            answer.push(tempArray[j][i]);
        }   
    }

    return answer;
}

let n = 10;
let answer = solution(n);
function solution(answers) {
    var answer = [];
    
    let count = [0,0,0];
    
    let method1 = [1,2,3,4,5];
    let method2 = [2,1,2,3,2,4,2,5];
    let method3 = [3,3,1,1,2,2,4,4,5,5];
    
    answers.forEach((item, idx)=>{
        if(method1[idx%5] === item) count[0]++;
        if(method2[idx%8] === item) count[1]++;
        if(method3[idx%10] === item) count[2]++;
    });
    
    let max = Math.max(...count);
    
    count.forEach((item, idx) => {
        if(item === max) answer.push(idx+1);
    })
    
    return answer;
}
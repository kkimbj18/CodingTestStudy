function solution(progresses, speeds) {
    var answer = [];
    let phase = 0;

    while(progresses.length > 0) {
        for (let i in progresses) {
            progresses[i] += speeds[i];
        }
        if(progresses[0] >= 100){
            answer.push(0);
            while(progresses[0] >= 100) {
                progresses.shift();
                speeds.shift();
                answer[phase]++;
            }
            phase++;
        }
    }
    
    return answer;
}
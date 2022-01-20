function solution(participant, completion) {
    var answer = '';
    let cnt = {};
    
    completion.forEach((e)=>{
        cnt[e] = (cnt[e]) ? cnt[e] + 1 : 1;
    });
    
    for (let target of participant){
        if(!cnt[target]){
            answer = target;
            break;
        }
        else if(cnt[target] > 0)
            cnt[target]--;
        else{
            answer = target;
            break;
        }
    }
    
    return answer;
}

/*
function solution(participant, completion) {
    var newList = completion.reduce((acc, c) => {
        acc[c] = (acc[c]) ? (acc[c] + 1) : 1;
        return acc;
    }, {});
    return participant.find((c) => {
        if (newList[c]) {
            newList[c] -= 1;
        } else {
            return true;
        }
    });
}
*/

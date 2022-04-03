function solution(array, commands) {
    var answer = [];
    let temp = [];
    
    commands.forEach((item)=>{
        temp = array.slice(item[0]-1,item[1]);
        temp.sort((a,b)=>{
            return a-b;
        });
        answer.push(temp[item[2]-1]);
    })
    
    return answer;
}
function solution(priorities, location) {
    var answer = 1;
    let target = priorities[location];
    let temp, max;
    
    while(1){
        temp = priorities.shift();
        max = max ? max : temp;
        
        if(temp < max) {
            priorities.push(temp);
            location--;
        }
        else {
            for(let i in priorities) {
                if(priorities[i] > temp) {
                    max = priorities[i];
                    priorities.push(temp);
                    location--;
                    break;
                }
            }
            if(temp >= max) {
                if(location == 0) {
                    break;
                }
                else {
                    max = 0;
                    location--;
                }
                answer++;
            }
        }
        
        location = location < 0 ? priorities.length - 1 : location;
    }
    
    return answer;
}
function solution(bridge_length, weight, truck_weights) {
    var answer = 0;
    let total_weight = 0;
    let temp = [];
    let count = [];
    
    let remain_weight = truck_weights.reduce((acc, item)=>{
        acc += item;

        return acc;
    }, 0);
    
    while(1){
        if(remain_weight <= weight) {
            answer += bridge_length + truck_weights.length;
            break;
        }

        answer++;
        
        if(truck_weights[0] + total_weight <= weight) {
            total_weight += truck_weights[0];
            temp.push(truck_weights.shift());
            count.unshift(0);
        }
        
        if(count.length==0) break;
        
        for(let i in count) {
            count[i]++;
            if(bridge_length == count[i]) {
                count.pop();
                let tmp = temp.shift();
                total_weight -= tmp;
                remain_weight -= tmp;
            }
        }
    }
    
    return answer;
}
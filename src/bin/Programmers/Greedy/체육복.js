function solution(n, lost, reserve) {
    var answer = 0;
    
    const lost_filter = lost.filter(val => !reserve.includes(val));
    const reserve_filter = reserve.filter(val => !lost.includes(val));
    
    lost_filter.sort((a,b)=>a-b);
    reserve_filter.sort((a,b)=>a-b);
    
    let lost_count = lost_filter.length;
    
    lost_filter.some((item)=>{
        let available = reserve_filter.findIndex((element)=>Math.abs(element - item) === 1);
        if(available != -1) {
            reserve_filter.splice(available,1);
            lost_count--;
        }
    });
    
    return answer = n - lost_count;
}
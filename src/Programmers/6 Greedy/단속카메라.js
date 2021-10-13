function solution(routes) {
    var answer = 1;
    let available = [];
    
    routes.sort((a,b)=>{
        return a[0] - b[0];
    })
    
    available.push([routes[0][0], routes[0][1]]);
    
    routes.forEach((item)=>{
        const result = available.some((v)=>{
            if(v[0] > item[1] || v[1] < item[0]) return false;
            else {
                if(item[0] > v[0])
                    v[0] = item[0];
                if(item[1] < v[1])
                    v[1] = item[1];
                return true;
            }
        });
        if(!result) {
            available.push([item[0], item[1]]);
            answer++;
        }
    });
    
    // console.log(available);
    
    return answer;
}
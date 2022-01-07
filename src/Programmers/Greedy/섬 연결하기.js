function solution(n, costs) {
    const MAX_NUM = Number.MAX_SAFE_INTEGER;
    var answer = 0;
    let visited = [];
    let min_dist = [];
    
    let dist = new Array(n);
    for(let i = 0; i < n; i++){
        dist[i] = new Array(n).fill(MAX_NUM);
        visited[i] = false;
    }
    
    costs.forEach((item)=>{
        dist[item[0]][item[1]] = item[2];
        dist[item[1]][item[0]] = item[2];
    });
    
    visited[0] = true;
    min_dist[0] = 0;
    
    for(let i = 0; i < n; i++) {
        min_dist[i] = dist[0][i];
    }
    
    for(let j = 0; j < n - 1; j++) {
        let min = MAX_NUM;
        let minIdx = -1;
        for(let i = 0; i < n; i++) {
            if(min_dist[i] < min && !visited[i]) {
                min = min_dist[i];
                minIdx = i;
            }
        }
        if(minIdx != -1) {
            visited[minIdx] = true;
            answer += min;
            for(let i = 0; i < n; i++) {
                if(visited[i]) continue;
                if(min_dist[i] > dist[minIdx][i]) min_dist[i] = dist[minIdx][i];
            }
        }
        // console.log(min_dist);
    }
    
    // console.log(dist);
    
    return answer;
}
function solution(genres, plays) {
    var answer = [];
    
    let genreSorted = [];
    let g_cnt = {};
    let max = {};
    
    for(let i = 0; i < genres.length; i++) {
        if(g_cnt[genres[i]]) {
            g_cnt[genres[i]] += plays[i];
            
            if(plays[max[genres[i]][1]] < plays[i]){
                if(plays[max[genres[i]][0]] < plays[i]){
                    max[genres[i]][1] = max[genres[i]][0];
                    max[genres[i]][0] = i;
                }
                else {
                    max[genres[i]][1] = i;
                }
            }
            else if(max[genres[i]][0] == max[genres[i]][1] && 0 < plays[i]) {
                max[genres[i]][1] = i;
            }
        }
        else {
            g_cnt[genres[i]] = plays[i];
            max[genres[i]] = [
                i,
                i
            ]
        }
    }
    
    genreSorted = Object.keys(g_cnt).sort((a,b) => { return g_cnt[b] - g_cnt[a]});
    
    for(let i in genreSorted) {
        let key = genreSorted[i];
        console.log(max[key][0], max[key][1], key);
        if(max[key][0] == max[key][1])
            answer.push(max[key][0]);
        else {
            answer.push(max[key][0]);
            answer.push(max[key][1]);
        }
    }
    
    return answer;
}
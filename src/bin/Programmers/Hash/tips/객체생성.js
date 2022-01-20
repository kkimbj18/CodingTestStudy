function solution(genres, plays) {
    var answer = [];
    
    let g_cnt = {};
    
    for(let i = 0; i < genres.length; i++) {
        if(g_cnt[genres[i]]){
            if(plays[g_cnt[genres[i]].max2] < plays[i]) {
                if(plays[g_cnt[genres[i]].max] < plays[i]) {
                    plays[g_cnt[genres[i]].max2] = plays[g_cnt[genres[i]].max];
                    plays[g_cnt[genres[i]].max] = plays[i];
                }
                else {
                    plays[g_cnt[genres[i]].max2] = plays[i];
                }
            }
            g_cnt[genres[i]].count += plays[i];
        }
        else {
            g_cnt[genres[i]] = {
                max : i,
                max2 : i,
                count : plays[i]
            };
        }
    }

    console.log(g_cnt);
        
    return answer;
}
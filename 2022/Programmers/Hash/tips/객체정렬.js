function solution(genres, plays) {
    var answer = [];
    
    let sortobj = [];
    let g_cnt = {};
    
    for(let i = 0; i < genres.length; i++) {
        g_cnt[genres[i]] = g_cnt[genres[i]] ? g_cnt[genres[i]] + plays[i] : plays[i];
    }
    
    for (let key in g_cnt) {
      sortobj.push([key, g_cnt[key]]);
    }
    
    sortobj.sort((a,b)=>{
        return b[1] - a[1];
    });
        
    return answer;
}

// key 값만 정렬해서 뽑아내기
// genreSorted = Object.keys(g_cnt).sort( function(a,b){ return g_cnt[b] - g_cnt[a]});
function solution(clothes) {
    var answer = 0;
    let result = 1;
    
    let category_cnt = clothes.reduce((acc, category) => {
        acc[category[1]] = acc[category[1]] ? acc[category[1]] + 1 : 2;
        
        return acc;
    }, {});
    
    for (let key in category_cnt) {
        result *= category_cnt[key];
    }

    return answer = result - 1;
}
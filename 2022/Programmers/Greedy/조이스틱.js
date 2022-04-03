function solution(name) {
    var answer = 0;
    let count = 0;
    
    const end = "Z".charCodeAt(0);
    const start = "A".charCodeAt(0);
    
    let criteria_string = "";
    
    for(let i = 0; i < Math.floor(name.length / 2); i++)
        criteria_string += 'A';
    
    const cri_index = name.indexOf(criteria_string);
    
    count += (name.indexOf('A') === 1 || name.indexOf('A') === name.length - 1) ? -2 : -1;
    let array = Array.from(name);
    
    array.forEach((item)=>{
        const asc_item = item.charCodeAt(0);
        if(asc_item > "N".charCodeAt(0)) {
            count += end - asc_item + 1;
        }
        else {
            count += asc_item - start;
        }
        count++;
    });
    
    return answer = count;
}
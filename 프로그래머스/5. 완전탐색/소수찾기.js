function solution(numbers) {
    var answer = 0;
    let result = [];
    
    let arr = numbers.split("");
    
    for(let i = 0; i < numbers.length; i++) {
        result = result.concat(permutation(arr, i+1));
    }
    
    result = result.map(v => Number(v));
    
    result = [...new Set(result)];
    
    answer = result.length - findPrime(result);
    
    return answer;
}
function findPrime(arr) {
    let sqrt_num = 0;
    let count = 0;
    
    loop1:
    for(let i in arr) {
        if(arr[i] == 1 || arr[i] == 0) {
            count++;
            continue;
        }
        sqrt_num = Math.sqrt(arr[i]);
        for(let j = 2; j <= sqrt_num; j++){
            if(arr[i] % j === 0) {
                count++;
                continue loop1;
            }
        }
    }
    
    return count;
}
function permutation(arr, num) {
    let result = [];
    if(num === 1) {
        return arr;
    }
    
    arr.forEach((item, idx, items)=>{
        const fixer = item;
        const restArr = items.filter((_,index)=>index !== idx);
        const permutatedArr = permutation(restArr, num-1);
        const combinedArr = permutatedArr.map((v)=>[fixer, ...v]);
        const resultArr = combinedArr.reduce((acc,item)=>{
            acc.push(item.join(""));
            
            return acc;
        },[]);
        result = result.concat(resultArr);
    });
    
    return result;
}
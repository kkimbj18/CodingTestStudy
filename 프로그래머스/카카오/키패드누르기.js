function solution(numbers, hand) {
    var answer = '';
    let prevLeft = 4;
    let prevRight = 4;
    let isRightCenter = false;
    let isLeftCenter = false;
    let intLoc;
    
    numbers.some((n)=>{
        intLoc = Math.floor(n/3);
        
        if (n % 3 === 0) {
            if (n === 0) {
                whichHand(n);
                return false;
            }
            answer += 'R';
            prevRight = intLoc;
            isRightCenter = false;
        }
        else if (n % 3 === 1) {
            answer += 'L';
            prevLeft = intLoc + 1;
            isLeftCenter = false;
        }
        else if (n % 3 === 2) {
            whichHand(n);
        }
        // console.log(prevLeft, prevRight, answer);
    })
    
    function whichHand(n) {
        let loc = (n==0) ? 4 : intLoc+1;
        const leftDiff = (isLeftCenter) ? Math.abs(prevLeft - loc) : Math.abs(prevLeft - loc) + 1;
        const rightDiff = (isRightCenter) ? Math.abs(prevRight - loc) : Math.abs(prevRight - loc) + 1;
        let diff = leftDiff - rightDiff;

        if (diff > 0) {
            answer += 'R';
            prevRight = loc;
            isRightCenter = true;
        }
        else if (diff === 0) {
            if (hand === 'right') {
                answer += 'R';
                prevRight = loc;
                isRightCenter = true;
            }
            else {
                answer += 'L';
                prevLeft = loc;
                isLeftCenter = true;
            }
        }
        else {
            answer += 'L'
            prevLeft = loc;
            isLeftCenter = true;
        }
    }
    
    return answer;
}
function solution(money, cost) {
    let answer = 0;

    let left = 0;
    let right = cost.length - 1;

    let temp = cost.reduce((acc, e) => {
        return acc += e;
    }, 0);

    while (true) {
        if (left > cost.length) break;

        console.log(left, right);

        if (temp > money) {
            if (left != right) {
                temp -= cost[right];
                right--;
            }
        }
        else {
            if (answer < right - left) answer = right - left;
            temp -= cost[left];
            left++;
            right = cost.length - 1;
            for (let i = left; i < cost.length; i++) temp += cost[i];
        }
    }

    return answer;
}

const money = 420;
const cost = [0, 900, 0, 200, 150, 0, 30, 50];

const result = solution(money, cost);

console.log(result);

function solution(k, rates) {
    let answer = k;
    let hasDollar = false;
    let index = 0;

    while (true) {
        if (index == rates.length) break;

        if (!hasDollar) {
            if (rates[index] < rates[index + 1]) {
                if (rates[index] <= answer) {
                    answer -= rates[index];
                    hasDollar = true;
                }
            }
        }
        else {
            if (rates[index] > rates[index + 1] || index === rates.length - 1) {
                answer += rates[index];
                hasDollar = false;
            }
        }

        index++;
    }

    return answer;
}
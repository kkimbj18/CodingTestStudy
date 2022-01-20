function bubble(arr, N) {
    for (let i = N-1; i > 0; i--) {
        for (let j = 0; j < i; j++) {
            if (arr[j] > arr[j+1]) {
                let temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

const arr = [675, 235, 59, 100, 48, 1, 3, 354, 3, 234, 6557, 878787, 12];

bubble(arr, 13);

console.log(arr);
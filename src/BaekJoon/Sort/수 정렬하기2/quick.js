function qsort(arr, l, r) {
    if (l >= r) return;

    let pivot = l;
    let left = pivot + 1;
    let right = r;

    while (left <= right) {
        while (left <= r && arr[left] <= arr[pivot]) {
            left++;
        }
        while (right > l && arr[right] > arr[pivot]) {
            right--;
        }
        console.log(left + " " + arr[left] + " " + right + " " + arr[right]);
        if (left <= right) {
            // console.log("0");
            swap(arr, left, right);
        }
        // console.log(arr[left] + " " + arr[right]);
    }

    swap(arr, pivot, right);

    qsort(arr, l, right - 1);
    qsort(arr, right + 1, r);
}

function swap(arr, l, r) {
    let temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
}

const arr = [675, 235, 59, 100, 48, 1, 3, 3, 234, 6557, 878787, 12];
qsort(arr, 0, arr.length - 1);

console.log(arr);
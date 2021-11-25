public class quick {
    public static void main(String[] args) {
        int[] arr = { 675, 235, 59, 100, 48, 1, 3, 354, 3, 234, 6557, 878787, 12 };

        quickSort(arr, 0, arr.length - 1);

        printArr(arr);
    }
    
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int l = start + 1;
        int r = end;

        while (l <= r) {
            while (l <= r && arr[l] < arr[start])
                l++;
            while (l <= r && arr[r] >= arr[start])
                r--;

            if (l <= r) {
                swap(arr, l, r);
            }
        }
        swap(arr, r, start);

        quickSort(arr, start, r - 1);
        quickSort(arr, r + 1, end);
    }
    
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

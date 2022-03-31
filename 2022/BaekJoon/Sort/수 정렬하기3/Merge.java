import java.util.ArrayList;

public class Merge {
    static int[] temp;

    public static void main(String[] args) {
        int[] arr = { 675, 235, 59, 100, 48, 1, 3, 354, 3, 234, 6557, 878787, 12 };

        temp = new int[arr.length];

        mergeSort(arr);

        printArr(arr);
    }

    public static void mergeSort(int[] arr) {
        divide(arr, 0, arr.length-1);
    }

    public static void divide(int[] arr, int start, int end) {
        if (start == end)
            return;

        int mid = (start + end) / 2;

        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        merge(arr, start, end);
    }

    public static void merge(int[] arr, int start, int end) {
        int l = start;
        int mid = (start + end) / 2;
        int r = mid + 1;

        int count = start;

        while (l <= mid && r <= end) {
            if (arr[l] > arr[r]) {
                temp[count++] = arr[r++];
            } else {
                temp[count++] = arr[l++];
            }
        }

        while(count <= end) {
            temp[count++] = (l > mid) ? arr[r++] : arr[l++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

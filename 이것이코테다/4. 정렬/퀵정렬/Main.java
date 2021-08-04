import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        qSort(0, N - 1, arr);
        
        for (int item : arr) {
            System.out.println(item);
        }
    }
    
    public static void qSort(int start, int end, int[] arr) {
        if (start >= end)
            return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot]) {
                left++;
            }
            while (right > start && arr[right] >= arr[pivot]) {
                right--;
            }

            if (right < left) {
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            } else {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        
        qSort(start, right - 1, arr);
        qSort(right + 1, end, arr);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(arr);

        System.out.println(binarySearch(0, 1000000000, arr, M));
        
    }

    public static int binarySearch(int start, int end, int[] arr, int target) {
        if (start > end)
            return start;

        int mid = (start + end) / 2;

        int midValue = 0;

        for (int a : arr) {
            midValue = (a - mid > 0) ? midValue + a - mid : midValue + 0;
        }

        if (midValue > target) {
            return binarySearch(mid + 1, end, arr, target);
        } else if (midValue < target) {
            return binarySearch(start, mid - 1, arr, target);
        } else
            return mid;
    }
}

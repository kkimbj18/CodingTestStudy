import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int result = binarySearch(0, N - 1, arr, target);
        
        System.out.println(result);
    }

    public static int binarySearch(int start, int end, int[] arr, int target) {
        if (start > end)
            return -1;
        
        int mid = (start + end) / 2;

        if (arr[mid] == target)
            return mid;

        if (target > arr[mid]) {
            return binarySearch(mid+1, end, arr, target);
        } else {
            return binarySearch(start, mid-1, arr, target);
        }
    }
}
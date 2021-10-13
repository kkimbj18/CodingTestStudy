import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] store = new int[N];

        for (int i = 0; i < N; i++) {
            store[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] customer = new int[M];

        for (int i = 0; i < M; i++) {
            customer[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(store);

        for (int c : customer) {
            if (binarySearch(0, N - 1, store, c)) {
                System.out.println("yes");
            } else System.out.println("no");
        }
    }
    
    public static boolean binarySearch(int start, int end, int[] arr, int target) {
        if (end < start)
            return false;

        int mid = (end + start) / 2;

        if (arr[mid] < target) {
            return binarySearch(mid + 1, end, arr, target);
        } else if (arr[mid] == target) {
            return true;
        } else {
            return binarySearch(start, mid - 1, arr, target);
        }
    }
}

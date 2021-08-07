import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}

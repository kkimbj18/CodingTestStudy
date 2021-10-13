import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            if (A[i] < B[i])
                A[i] = B[i];
            else
                break;
        }

        int sum = 0;

        for (Integer value : A) {
            sum += value;
        }

        System.out.println(sum);
    }
}

import java.util.Scanner;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        sc.close();

        if (K == 0) {
            System.out.println(1);
            return;
        }

        long a = N;
        long b = 1;

        int c = Math.min(K, N - K);

        for (int i = 1; i < c; i++) {
            a *= N - i;
            System.out.println(a);
            // if (a > 1000000007)
            //     a %= 1000000007;
            b *= i + 1;
        }

        long answer = a / b;
        answer %= 1000000007;

        System.out.println(answer);
    }
}

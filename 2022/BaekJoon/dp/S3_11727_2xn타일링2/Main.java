import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 3;

            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i-2]*2+dp[i-1]) % 10007;
            }
        }

        System.out.println(dp[n]);
    }
}

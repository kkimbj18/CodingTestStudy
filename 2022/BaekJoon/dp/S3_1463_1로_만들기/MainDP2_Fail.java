import java.util.*;

public class MainDP2_Fail {

    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new int[N+1];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        System.out.println(cal(N));
    }

    private static int cal(int n) {
        System.out.println(n + " " + dp[n]);
        if (n == 1) return 0;
        if (dp[n] > 0) return dp[n];
        // System.out.println("A");

        dp[n] = cal(n-1) + 1;
        if (n % 3 == 0) dp[n] = Math.min(cal(n/3) + 1, dp[n]);
        if (n % 2 == 0) dp[n] = Math.min(cal(n/2) + 1, dp[n]);

        return dp[n];
    }
}

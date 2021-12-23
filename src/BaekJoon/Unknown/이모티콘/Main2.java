import java.util.*;

public class Main2 {
    static int S;
    static int[][] dp;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.nextInt();
        sc.close();

        dp = new int[S+1][S+1];

        for (int i = 0; i <= S; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][1] = 0;

        for (int i = 0; i < 3; i++) {
            memoization(0, 1, i);
        }

        printAll();

        System.out.println(min);
    }
    
    public static void memoization(int capture, int now, int type) {
        // System.out.println(capture + " " + now + " " + dp[capture][now] + " " + type);

        if (dp[capture][now] >= min)
            return;

        int tempC = capture;
        int tempN = now;


        if (type == 0) {
            if (capture == now)
                return;

            tempC = now;
        } else if (type == 1) {
            tempN += capture;
        } else {
            tempN -= 1;
        }

        // System.out.println(tempC + " " + tempN + " " + dp[tempC][tempN] + " " + type);

        if (tempC < 0 || tempN < 0 || tempC > S || tempN > S)
            return;

        if (dp[tempC][tempN] > dp[capture][now])
            dp[tempC][tempN] = dp[capture][now] + 1;
        else
            return;

        // System.out.println(tempC + " " + tempN + " " + dp[tempC][tempN] + " " + type);

        if (tempN == S) {
            if (dp[tempC][tempN] < min) {
                min = dp[tempC][tempN];
            }

            return;
        }

        for (int i = 0; i < 3; i++) {
            memoization(tempC, tempN, i);
        }
    }

    public static void printAll() {
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}

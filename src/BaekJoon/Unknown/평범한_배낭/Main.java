import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Object[] objectArr;
    static int[][] dp;
    static int K;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        dp = new int[N+1][K + 1];
        objectArr = new Object[N+1];

        for (int i = 1; i <= N; i++) {
            int wTemp = sc.nextInt();
            int vTemp = sc.nextInt();

            objectArr[i] = new Object(wTemp, vTemp);
        }

        sc.close();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= objectArr[i].w)
                    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - objectArr[i].w]) + objectArr[i].v);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[N][K]);
    }
}

class Object {
    int w;
    int v;

    Object(int w, int v) {
        this.w = w;
        this.v = v;
    }
}
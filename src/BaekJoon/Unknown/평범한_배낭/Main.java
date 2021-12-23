import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static Object[] objectArr;
    static int[][] dp;
    static int K;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][K + 1];
        objectArr = new Object[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int wTemp = Integer.parseInt(st.nextToken());
            int vTemp = Integer.parseInt(st.nextToken());

            objectArr[i] = new Object(wTemp, vTemp);
        }

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
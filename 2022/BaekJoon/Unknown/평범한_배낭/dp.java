import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Object[] objectArr;
    static int[] dp;
    static int K;
    static int N;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        dp = new int[K + 1];
        objectArr = new Object[N];

        for (int i = 0; i < N; i++) {
            int wTemp = sc.nextInt();
            int vTemp = sc.nextInt();

            objectArr[i] = new Object(wTemp, vTemp);
        }

        sc.close();

        for (int i = 0; i < N; i++) {
            boolean[] checked = new boolean[N];

            dfs(i, 0, checked);
        }

        System.out.println(max);
    }

    public static void dfs(int idx, int wsum, boolean[] checked) {
        if (checked[idx])
            return;

        int wsumTemp = wsum + objectArr[idx].w;
        if (wsumTemp > K)
            return;
        if (dp[wsumTemp] > dp[wsum] + objectArr[idx].v)
            return;

        checked[idx] = true;
        dp[wsumTemp] = objectArr[idx].v + dp[wsum];
        if (max < dp[wsumTemp])
            max = dp[wsumTemp];
        wsum += objectArr[idx].w;

        for (int i = 0; i < N; i++) {
            if (checked[i])
                continue;

            boolean[] checkedTemp = checked.clone();
            dfs(i, wsum, checkedTemp);
        }
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
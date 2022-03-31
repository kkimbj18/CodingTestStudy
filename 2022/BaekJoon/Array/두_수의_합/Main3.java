package BaekJoon.Array.두_수의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

    static int count = 0;

    static int x;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        comb(0, 0, 0);

        System.out.println(count);
    }

    public static void comb(int cnt, int start, int sum) {
        if (cnt == 2) {
            if (sum == x) count++;

            return;
        }

        for (; start < n; start++) {
            comb(cnt+1, start+1, sum + arr[start]);
        }
    }
}

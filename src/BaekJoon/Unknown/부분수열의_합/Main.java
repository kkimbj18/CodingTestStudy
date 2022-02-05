package BaekJoon.Unknown.부분수열의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] S = new int[N];
        boolean[] B = new boolean[100000 * N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < (1 << N); i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += S[j];
                }
            }
            B[sum] = true;
        }

        for (int i = 1; i <= 100000 * N + 1; i++) {
            if (!B[i]) {
                System.out.println(i);
                return;
            }
        }

    }
}

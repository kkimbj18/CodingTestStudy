package BaekJoon.Unknown.로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<int[]> list = new ArrayList<>();

        while(true) {
            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());

            if (K == 0) break;

            int[] arr = new int[K];

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            list.add(arr);
        }

        for (int[] arr: list) {
            comb(arr, 0, 0, new int[6]);
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void comb(int[] arr, int cnt, int start, int[] res) {
        if (cnt == 6) {
            for (int r: res) {
                sb.append(r + " ");
            }
            sb.append("\n");

            return;
        }

        for (; start < arr.length; start++) {
            res[cnt] = arr[start];
            comb(arr, cnt+1, start+1, res);
        }
    }
}

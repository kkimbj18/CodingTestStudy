package BaekJoon.Unknown.오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s = new Stack<>();

        int[] result = new int[N];

        for (int i = N-1; i >= 0; i--) {
            int res;

            while(!s.isEmpty()) {
                if (s.peek() <= arr[i]) {
                    s.pop();
                } else break;
            }

            if (s.isEmpty()) res = -1;
            else res = s.peek();

            result[i] = res;

            s.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(result[i] + " ");
        }

        System.out.println(sb.toString());
    }
}

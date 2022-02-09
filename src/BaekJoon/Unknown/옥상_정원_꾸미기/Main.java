package BaekJoon.Unknown.옥상_정원_꾸미기;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        long answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        br.close();

        Stack<Long> s = new Stack<>();

        s.push(arr[0]);

        for (int i = 1; i < N; i++) {
            while (!s.empty() && s.peek() <= arr[i]) {
                s.pop();
            }

            answer += s.size();

            s.push(arr[i]);
        }

        System.out.println(answer);
    }
}

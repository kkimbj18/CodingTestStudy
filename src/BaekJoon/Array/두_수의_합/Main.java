package BaekJoon.Array.두_수의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int MAX = 1000001;

        int[] arr = new int[n];
        boolean[] isNumExist = new boolean[MAX];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            isNumExist[arr[i]] = true;
        }

        int x = Integer.parseInt(br.readLine());

        br.close();

        int count = 0;

        for (int a: arr) {
            int sub = x-a;

            if (sub < 0 || sub >= MAX) continue;

            if (isNumExist[sub]) count++;
        }

        System.out.println(count/2);
    }
}


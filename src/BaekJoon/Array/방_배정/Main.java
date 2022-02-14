package BaekJoon.Array.방_배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = 0;

        int A = 7;
        int B = 2;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[A][B];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            arr[Y][S]++;
        }

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                double needRoom = Math.ceil((double)arr[i][j] / K);

                count += needRoom;
            }
        }

        System.out.println(count);
    }
}

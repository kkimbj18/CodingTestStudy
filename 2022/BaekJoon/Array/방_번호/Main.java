package BaekJoon.Array.방_번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] roomNum = br.readLine().toCharArray();

        int[] counts = new int[10];

        for (char n: roomNum) {
            counts[n-'0']++;
        }

        int max = -1;

        counts[6] = (int)Math.ceil((double)(counts[6] + counts[9]) / 2);
        counts[9] = 0;

        for (int count: counts) {
            if (count > max) max = count;
        }

        System.out.println(max);
    }
}

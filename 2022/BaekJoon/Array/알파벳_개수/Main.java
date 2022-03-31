package BaekJoon.Array.알파벳_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = br.readLine().toCharArray();
        int[] counts = new int[26];

        for (char w: word) {
            counts[w-97]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int count: counts) {
            sb.append(count + " ");
        }

        System.out.println(sb.toString());
    }
}

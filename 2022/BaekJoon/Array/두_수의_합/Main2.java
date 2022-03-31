package BaekJoon.Array.두_수의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        br.close();

        // System.out.println(Arrays.toString(arr));

        int start = 0;
        int end = n-1;
        int count = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];

            while(sum < x && start < end) {
                sum = arr[++start] + arr[end];
            }
            while(sum > x && start < end) {
                sum = arr[start] + arr[--end];
            }
            
            if (sum == x && start < end) {
                count++;
                end--;
            }
        }

        System.out.println(count);
    }
}
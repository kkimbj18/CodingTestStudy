package BackJoon.BackTracking.N°úM1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        int M = sc.nextInt();
        
        sc.close();
        
        boolean[] visited = new boolean[N];
        int[] arr = new int[M];
        Arrays.fill(visited, false);

        solution(N, M, visited, arr, 0, bw);
        
        bw.flush();
        bw.close();
    }

    public static void solution(int N, int M, boolean[] visited, int[] arr, int depth, BufferedWriter bw) throws IOException {
        if (depth == M) {
        	for (int a : arr) {
        		bw.write(a + " ");
        	}
        	bw.write("\n");
        	return;
        }
        
        for (int i = 0; i < N; i++) {
        	if (!visited[i]) {
        		visited[i] = true;
        		arr[depth] = i+1;
        		solution(N, M, visited, arr, depth+1, bw);
        		visited[i] = false;
        	}
        }
    }
}
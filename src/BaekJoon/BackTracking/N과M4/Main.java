package BackJoon.BackTracking.N°úM4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		sc.close();
		
		int[] arr = new int[M];
		
		solution(arr, 0);
		
		bw.flush();
		bw.close();
	}
	
	public static void solution(int[] arr, int depth) throws IOException {
		if (depth == M) {
			for (int a : arr) {
				bw.write(a + " ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (depth != 0) {
				if (arr[depth-1] > i+1) continue;
			}
			arr[depth] = i + 1;
			solution(arr, depth+1);
		}
	}
}

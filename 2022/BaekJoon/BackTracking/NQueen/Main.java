package BackJoon.BackTracking.NQueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		solution(N, 0, arr);
		
		bw.write(answer+"\n");
		
		bw.flush();
		bw.close();
	}
	
	public static void solution(int N, int phase, int[] arr) {
		if (phase == N) {
			answer++;
			return;
		}
		
		Loop1:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < phase; j++) {
				if (arr[j] == i) continue Loop1;
				if (arr[j] - (phase-j) == i) continue Loop1;
				if (arr[j] + (phase-j) == i) continue Loop1;
			}
			
			arr[phase] = i;
			solution(N, phase+1, arr);
		}
	}
}

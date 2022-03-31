package BackJoon.Samsung.시험_감독;

import java.util.Scanner;

public class Main {
	static int N;
	static int B;
	static int C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		B = sc.nextInt();
		C = sc.nextInt();
		
		sc.close();
		
		long count = 0;
		
		for (int i = 0; i < N; i++) {
			A[i] -= B;
		}
		count += N;
		
		for (int i = 0; i < N; i++) {
			if (A[i] < 1) continue;
			
			long div = (long)(A[i] / C);
			int rest = A[i] % C;
			
			if (rest != 0) count += div+1;
			else count += div;
		}
		
		System.out.println(count);
	}
}

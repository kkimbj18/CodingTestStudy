package BackJoon.Samsung.마법사_상어와_비바라기;

import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static Map[][] A;
	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static Move[] move;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer[]> q = new LinkedList<>();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		A = new Map[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int vtemp = sc.nextInt();
				A[i][j] = new Map(vtemp, false, false);
			}
		}
		
		for (int i = N-2; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				A[i][j].cloud = true;
			}
		}
		
		move = new Move[M];
		
		for (int i = 0; i < M; i++) {
			int dtemp = sc.nextInt();
			int vtemp = sc.nextInt();
			move[i] = new Move(dtemp, vtemp);
		}
		
		sc.close();
		
		for (int i = 0; i < M; i++) {
			int d = move[i].direction;
			int v = move[i].value;
			
			for (int y = 0; y < N; y++) {
				int ty = y + v * dy[d];
				
				if (ty > N-1) ty %= N;
				else if (ty < 0) {
					while (ty < 0) {
						ty = N+ty;
					}
				}

				for (int x = 0; x < N; x++) {
					int tx = x + v * dx[d];
					
					if (tx > N-1) tx %= N;
					else if (tx < 0) {
						while (tx < 0) {
							tx = N+tx;
						}
					}
					
					if (A[y][x].cloud) {
						q.add(new Integer[] {ty, tx});
						A[y][x].cloud = false;
					}
				}
			}
			
			while(!q.isEmpty()) {
				Integer[] temp = q.poll();
				int y = temp[0];
				int x = temp[1];
				
				A[y][x].value++;
				A[y][x].cloud = true;
			}
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (A[y][x].cloud) {
						A[y][x].cloud = false;
						A[y][x].isDone = true;
						A[y][x].value += check(y, x);
					}
				}
			}
			
//			print(i);
			
			// 구름 생성
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (A[y][x].isDone) {
						A[y][x].isDone = false;
						continue;
					}
					
					if (A[y][x].value >= 2) {
						A[y][x].cloud = true;
						A[y][x].value -= 2;
					}
				}
			}
			
//			print(i);
		}
		
		sum();
	}
	
	public static int check(int y, int x) {
		int count = 0;
		
		for (int i = 2; i <= 8; i = i+2) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			
			if (ty < 0 || tx < 0 || ty > N-1 || tx > N-1) continue;
			
			if (A[ty][tx].value > 0) count++;
		}
		
		return count;
	}
	
	public static void print(int phase) {
		System.out.println(phase);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(A[i][j].value + " ");
			}
			System.out.println();
		}
	}
	
	public static void sum() {
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += A[i][j].value;
			}
		}
		
		System.out.println(sum);
	}
}

class Move {
	int direction;
	int value;
	
	Move(int d, int v) {
		direction = d;
		value = v;
	}
}

class Map {
	int value;
	boolean isDone;
	boolean cloud;
	
	Map(int v, boolean d, boolean c) {
		value = v;
		isDone = d;
		cloud = c;
	}
}

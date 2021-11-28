package BackJoon.Samsung.±∏ΩΩ_≈ª√‚_2;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static char[][] map;
	static int min = 11;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		map = new char[N][M];
		
		int[] red = null;
		int[] blue = null;
		
		for (int i = 0; i < N; i++) {
			String temp = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'R') red = new int[] {i, j};
				else if (map[i][j] == 'B') blue = new int[] {i, j};
			}
		}
		
		sc.close();
		
		for (int i = 0; i < 4; i++) {
			move(1, i, red[0], red[1], blue[0], blue[1]);
		}
		
		if (min == 11) System.out.println(-1);
		else System.out.println(min);
	}
	
	public static void move(int count, int d, int ry, int rx, int by, int bx) {
		if (count >= min) return;
		
		int rstop = 0;
		int bstop = 0;
		int clear = 0;
		
		while(true) {
			if (rstop == 1 && bstop == 1) break;
			
			if (rstop == 0) {
				if (ry+dy[d] == by && rx+dx[d] == bx) {
					if (map[by+dy[d]][bx+dx[d]] == '#') break;
				}
				
				if (map[ry+dy[d]][rx+dx[d]] == '#') {
					rstop = 1;
				} else if (map[ry+dy[d]][rx+dx[d]] == 'O') {
					clear = 1;
					rstop = 1;
				} else {
					ry += dy[d];
					rx += dx[d];
				}
			}
			
			if (bstop == 0) {
				if (map[by+dy[d]][bx+dx[d]] == '#' || (by+dy[d] == ry && bx+dx[d] == rx && clear != 1)) {
					bstop = 1;
				} else if (map[by+dy[d]][bx+dx[d]] == 'O') {
					return;
				} else {
					by += dy[d];
					bx += dx[d];
				}
			}
		}
		
		if (clear == 1) {
			if (min > count) {
				min = count;
				return;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			move(count+1, i, ry, rx, by, bx);
		}
	}
}
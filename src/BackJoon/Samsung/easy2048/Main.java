package BackJoon.Samsung.easy2048;

import java.util.*;

public class Main {
	static int max = 0;
	static int N;
	
	public static void main(String[] args) {
		// ют╥б
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		Block[][] board = new Block[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				board[i][j] = new Block(temp, false);
				
				if (temp > max) max = temp;
			}
		}
		
		sc.close();
		
		for (int i = 0; i < 4; i++) {
			dfs(i, board, 5, 0);
		}
		
		System.out.println(max);
	}
	
	public static void print(Block[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j].value);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void dfs(int d, Block[][] prev_board, int rest, int m) {
		if (rest == 0) {
			findMax(prev_board);
			return;
		}
		
		Block[][] board = new Block[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = new Block(prev_board[i][j].value, false);
			}
		}
		
		merge(board, d);
		move(board, d);
		
		for (int i = 0; i < 4; i++) {
			dfs(i, board, rest-1, m);
		}
	}
	
	public static void findMax(Block[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j].value > max) {
					max = board[i][j].value;
				}
			}
		}
	}
	
	public static void move(Block[][] board, int d) {
		int[] count = new int[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (d == 0) {
					if (board[i][j].value == 0) continue;
					if (count[j] != i) {
						board[count[j]][j].value = board[i][j].value;
						board[i][j].value = 0;
					}
					
					count[j]++;
				} else if (d == 1) {
					if (board[N-i-1][j].value == 0) continue;
					if (count[j] != i) {
						board[N-count[j]-1][j].value = board[N-i-1][j].value;
						board[N-i-1][j].value = 0;
					}
					
					count[j]++;
				} else if (d == 2) {
					if (board[j][i].value == 0) continue;
					if (count[j] != i) {
						board[j][count[j]].value = board[j][i].value;
						board[j][i].value = 0;
					}

					count[j]++;
				} else {
					if (board[j][N-i-1].value == 0) continue;
					if (count[j] != i) {
						board[j][N-count[j]-1].value = board[j][N-i-1].value;
						board[j][N-i-1].value = 0;
					}
					
					count[j]++;
				}
				
			}
		}
	}
	
	public static void merge(Block[][] board, int d) {
		int[] loc = new int[N];
		boolean[] crash = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {	
				if (d == 0) {
					if (board[i][j].value == 0) continue;
					if (!crash[j]) {
						loc[j] = i;
						crash[j] = true;
						continue;
					}
					
					if (board[loc[j]][j].value == board[i][j].value) {
						board[loc[j]][j].value *= 2;
						board[i][j].value = 0;
						crash[j] = false;
					} else {
						loc[j] = i;
					}
				} else if (d == 1) {
					if (board[N-i-1][j].value == 0) continue;
					if (!crash[j]) {
						loc[j] = N-i-1;
						crash[j] = true;
						continue;
					}
					
					if (board[loc[j]][j].value == board[N-i-1][j].value) {
						board[loc[j]][j].value *= 2;
						board[N-i-1][j].value = 0;
						crash[j] = false;
					} else {
						loc[j] = N-i-1;
					}
				} else if (d == 2) {
					if (board[j][i].value == 0) continue;
					if (!crash[j]) {
						loc[j] = i;
						crash[j] = true;
						continue;
					}
					
					if (board[j][loc[j]].value == board[j][i].value) {
						board[j][loc[j]].value *= 2;
						board[j][i].value = 0;
						crash[j] = false;
					} else {
						loc[j] = i;
					}
				}  else if (d == 3) {
					if (board[j][N-i-1].value == 0) continue;
					if (!crash[j]) {
						loc[j] = N-i-1;
						crash[j] = true;
						continue;
					}
					
					if (board[j][loc[j]].value == board[j][N-i-1].value) {
						board[j][loc[j]].value *= 2;
						board[j][N-i-1].value = 0;
						crash[j] = false;
					} else {
						loc[j] = N-i-1;
					}
				}
			}
		}
	}
}

class Block {
	int value;
	boolean crash;
	
	Block(int value, boolean crash) {
		this.value = value;
		this.crash = crash;
	}
}

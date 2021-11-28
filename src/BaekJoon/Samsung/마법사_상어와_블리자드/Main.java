package BackJoon.Samsung.마법사_상어와_블리자드;

import java.util.*;

public class Main {
	static int N;
	static int M;
	static int sharkx;
	static int sharky;
	static Block[][] map;
	static Magic[] magics;
	static int[] result = new int[4];
	// 위, 아래, 왼쪽, 오른쪽
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, -1, 1};
	public static void main(String[] args) {
		// 인풋
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		sharky = (N-1)/2;
		sharkx = (N-1)/2;
		
		map = new Block[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int mtemp = sc.nextInt();
				map[i][j] = new Block(mtemp, 0);
			}
		}
		
		int y = 0;
		int x = -1;
		int n = N;
		int val = N * N;
		while(true) {
			for (int i = 0; i < n; i++) {
				val--;
				map[y][++x].value = val;
			}
			n--;
			if (n == 0) break;
			for (int i = 0; i < n; i++) {
				val--;
				map[++y][x].value = val;
			}
			for (int i = 0; i < n; i++) {
				val--;
				map[y][--x].value = val;
			}
			n--;
			for (int i = 0; i < n; i++) {
				val--;
				map[--y][x].value = val;
			}
		}
		
		magics = new Magic[M];
		
		for (int i = 0; i < M; i++) {
			int dirtemp = sc.nextInt();
			int distemp = sc.nextInt();
			
			magics[i] = new Magic(dirtemp, distemp);
		}
		
		Arrays.fill(result, 0);
		
		for (int i = 0; i < M; i++) {
			magic(i);
			
			Stack<Integer[]> s = new Stack<>();
			
			while(true) {
				pull();
//				print();
				check(s);
				if (s.isEmpty()) {
//					print();
					break;
				}
				bomb(s);
//				print();
			}
			
			change();
//			print();
		}
		
		sum();
		
		sc.close();
	}
	
	public static void sum() {
		int sum = 0;
		for (int i = 1; i < 4; i++) {
			sum += result[i] * i;
		}
		
		System.out.println(sum);
	}
	
	public static void change() {
		int y = sharky;
		int x = sharkx;
		int n = 1;
		
		int color = 0;
		int count = 0;
		
		Queue<Integer> q = new LinkedList<>();
		
		// 스캔
		looop:
		while(true) {
			for (int i = 0; i < n; i++) {
				if (map[y][--x].marble == 0) break looop;
				
				if (x == 0 && y == 0) break looop;
				
				if (color == map[y][x].marble) count++;
				else {
					if (color != 0) {
						q.add(count);
						q.add(color);
					}
					color = map[y][x].marble;
					count = 1;
				}	
			}
			
			if (n == N) break;
			
			for (int i = 0; i < n; i++) {
				if (map[++y][x].marble == 0) break looop;
				
				if (color == map[y][x].marble) count++;
				else {
					q.add(count);
					q.add(color);
					color = map[y][x].marble;
					count = 1;
				}
			}
			n++;
			for (int i = 0; i < n; i++) {
				if (map[y][++x].marble == 0) break looop;
				
				if (color == map[y][x].marble) count++;
				else {
					q.add(count);
					q.add(color);
					color = map[y][x].marble;
					count = 1;
				}
			}
			for (int i = 0; i < n; i++) {
				if (map[--y][x].marble == 0) break looop;
				
				if (color == map[y][x].marble) count++;
				else {
					q.add(count);
					q.add(color);
					color = map[y][x].marble;
					count = 1;
				}
			}
			n++;
		}
		
		q.add(count);
		q.add(color);
		
		y = sharky;
		x = sharkx;
		n = 1;
		
		// 다시 넣기
		while(true) {
			for (int i = 0; i < n; i++) {
				if (x == 0 && y == 0) return;
				
				if (q.isEmpty()) return;
				map[y][--x].marble = q.poll();					
			}
			
			if (n == N) break;
			
			for (int i = 0; i < n; i++) {
				if (q.isEmpty()) return;
				map[++y][x].marble = q.poll();
			}
			n++;
			for (int i = 0; i < n; i++) {
				if (q.isEmpty()) return;
				map[y][++x].marble = q.poll();
			}
			for (int i = 0; i < n; i++) {
				if (q.isEmpty()) return;
				map[--y][x].marble = q.poll();
			}
			n++;
		}
	}
	
	public static void bomb(Stack<Integer[]> s) {
		while(!s.isEmpty()) {
			Integer[] temp = s.pop();
			
			int yt = temp[0];
			int xt = temp[1];
			
//			System.out.println(map[yt][xt].marble + " " + result[map[yt][xt].marble]);
			result[map[yt][xt].marble]++;
			map[yt][xt].marble = 0;
		}
	}
	
	public static void check(Stack<Integer[]> s) {
		int y = 0;
		int x = -1;
		int n = N;
		int color = 0;
		int count = 0;
		boolean flag = false;
		while(true) {
			for (int i = 0; i < n; i++) {
				if (map[y][++x].marble == 0) continue;
				
				if (map[y][x].marble == color) {
					count++;
				}
				else {
					if (flag) flag = false;
					else {
						for (int j = 0; j < count; j++) {
							s.pop();
						}
					}
					color = map[y][x].marble;
					count = 1;
				}
				
				if (count == 4) flag = true;
				
				s.push(new Integer[] {y, x});
			}
			n--;
			if (n == 0) break;
			for (int i = 0; i < n; i++) {
				if (map[++y][x].marble == 0) continue;
				
				if (map[y][x].marble == color) {
					count++;
				}
				else {
					if (flag) flag = false;
					else {
						for (int j = 0; j < count; j++) {
							s.pop();
						}
					}
					color = map[y][x].marble;
					count = 1;
				}
				
				if (count == 4) flag = true;
				
				s.push(new Integer[] {y, x});
			}
			for (int i = 0; i < n; i++) {
				if (map[y][--x].marble == 0) continue;
				
				if (map[y][x].marble == color) {
					count++;
				}
				else {
					if (flag) flag = false;
					else {
						for (int j = 0; j < count; j++) {
							s.pop();
						}
					}
					color = map[y][x].marble;
					count = 1;
				}
				
				if (count == 4) flag = true;
				
				s.push(new Integer[] {y, x});
			}
			n--;
			for (int i = 0; i < n; i++) {
				if (map[--y][x].marble == 0) continue;
				
				if (map[y][x].marble == color) {
					count++;
				}
				else {
					if (flag) flag = false;
					else {
						for (int j = 0; j < count; j++) {
							s.pop();
						}
					}
					color = map[y][x].marble;
					count = 1;
				}
				
				if (count == 4) flag = true;
				
				s.push(new Integer[] {y, x});
			}
		}
		
		if (!flag) {
			for (int i = 0; i < count; i++) {
				s.pop();
			}
		}
	}
	
	public static void magic(int phase) {
		int dist = magics[phase].distance;
		int dir = magics[phase].direction;
		
		for (int i = 1; i <= dist; i++) {
			map[sharky + i * dy[dir]][sharkx + i * dx[dir]].marble = 0;
		}
	}
	
	public static void pull() {
		int y = sharky;
		int x = sharkx;
		int n = 1;
		
		Queue<Integer> q = new LinkedList<>();
		
		// 스캔
		Lp:
		while(true) {
			for (int i = 0; i < n; i++) {
				if (x == 0 && y == 0) break Lp;
				
				if (map[y][x].marble != 0) q.add(map[y][x].marble);
				x--;
			}
			
			if (n == N) break;
			
			for (int i = 0; i < n; i++) {
				if (map[y][x].marble != 0) q.add(map[y][x].marble);
				y++;
			}
			n++;
			for (int i = 0; i < n; i++) {
				if (map[y][x].marble != 0) q.add(map[y][x].marble);
				x++;
			}
			for (int i = 0; i < n; i++) {
				if (map[y][x].marble != 0) q.add(map[y][x].marble);
				y--;
			}
			n++;
		}
		
		y = sharky;
		x = sharkx;
		n = 1;
		
		// 다시 넣기
		while(true) {
			for (int i = 0; i < n; i++) {
				if (x == 0 && y == 0) return;
				
				if (q.isEmpty()) {
					map[y][--x].marble = 0;
					continue;
				}
				map[y][--x].marble = q.poll();		
			}
			
			if (n == N) break;
			
			for (int i = 0; i < n; i++) {
				if (q.isEmpty()) {
					map[++y][x].marble = 0;
					continue;
				}
				map[++y][x].marble = q.poll();
			}
			n++;
			for (int i = 0; i < n; i++) {
				if (q.isEmpty()) {
					map[y][++x].marble = 0;
					continue;
				}
				map[y][++x].marble = q.poll();
			}
			for (int i = 0; i < n; i++) {
				if (q.isEmpty()) {
					map[--y][x].marble = 0;
					continue;
				}
				map[--y][x].marble = q.poll();
			}
			n++;
		}
	}
	
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j].marble + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Magic {
	int direction;
	int distance;
	
	Magic(int dir, int dis) {
		direction = dir;
		distance = dis;
	}
}

class Block {
	int marble;
	int value;
	
	Block(int m, int v) {
		marble = m;
		value = v;
	}
}

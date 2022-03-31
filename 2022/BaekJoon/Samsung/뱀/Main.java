package BackJoon.Samsung.¹ì;

import java.util.*;

public class Main {
	static int N;
	static int K;
	static int L;
	static TurnPoint[] tp;
	static Map[][] map;
	// D, L, U, R
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	static int[] pos = {0, 0};
	static ArrayList<Integer[]> snake = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new Map[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new Map(false, false);
			}
		}
		
		K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int[] temp = new int[2];
			temp[0] = sc.nextInt() - 1;
			temp[1] = sc.nextInt() - 1;
			map[temp[0]][temp[1]].isApple = true;
		}
		
		L = sc.nextInt();
		sc.nextLine();
		tp = new TurnPoint[L];
		for (int i = 0; i < L; i++) {
			String p = sc.nextLine();
			String[] temp = p.split(" ");
			
			tp[i] = new TurnPoint(Integer.parseInt(temp[0]), temp[1].charAt(0));
		}
		
		sc.close();
		
		map[0][0].isSnake = true;
		snake.add(new Integer[] {0, 0});
		
		int t = 0;
		int d = 0;
		int phase = 0;
		while(true) {
			pos[0] += dy[d];
			pos[1] += dx[d];
			t++;
			
			if (pos[0] < 0 || pos[1] < 0 || pos[0] > N-1 || pos[1] > N-1) break;
			if (map[pos[0]][pos[1]].isSnake) break;
			
			map[pos[0]][pos[1]].isSnake = true;
			snake.add(new Integer[] {pos[0], pos[1]});
			
			if (map[pos[0]][pos[1]].isApple) {
				map[pos[0]][pos[1]].isApple = false;
			} else {
				Integer[] temp = snake.get(0);
				map[temp[0]][temp[1]].isSnake = false;
				snake.remove(0);
			}
			
//			System.out.println(pos[0] + " " + pos[1]);
			
			if (phase < L && tp[phase].time == t) {
				if (tp[phase].direction == 'D') {
					d = (d+1) % 4;
				} else {
					if (d == 0) d = 3;
					else d--;
				}
//				System.out.println(tp[phase].direction);
				phase++;
			}
		}
		
		System.out.println(t);
	}
}

class TurnPoint {
	int time;
	char direction;
	
	TurnPoint(int time, char d) {
		this.time = time;
		this.direction = d;
	}
}

class Map {
	boolean isApple;
	boolean isSnake;
	
	Map(boolean isApple, boolean isSnake) {
		this.isApple = isApple;
		this.isSnake = isSnake;
	}
}

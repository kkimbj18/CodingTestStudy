package SWExpert.줄기세포배양;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int[] rx = {-1, 0, 0, 1};
	static int[] ry = {0, -1, 1, 0};
	static int MAX = 350;
	static Node[][] graph = new Node[MAX][MAX];
	static int test_case;
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(test_case = 1; test_case <= T; test_case++)
		{
			
			for (int i = 0; i < MAX; i++) {
				for (int j = 0; j < MAX; j++) {
					graph[i][j] = new Node();
				}
			}
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int temp = sc.nextInt();
					
					if (temp != 0) graph[150+i][150+j] = new Node(temp, temp, true, false);
				}
			}
			
			bfs(K-1);
		
			print(test_case);
		}
		
		sc.close();
	}
	
	public static void bfs(int tl) {
		if (tl == -1) return;
		
		// 확장
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				if (!graph[i][j].isActive) continue;
				if (graph[i][j].life == graph[i][j].curr) {
					expand(i, j);
				}
			}
		}
		// curr--
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				if (!graph[i][j].isliving) continue;
				
				graph[i][j].curr--;
				
				if (graph[i][j].curr == 0) {
					if (!graph[i][j].isActive) {
						graph[i][j].isActive = true;
						graph[i][j].curr = graph[i][j].life;
					}
					else {
						graph[i][j].isActive = false;
						graph[i][j].isliving = false;
					}
				}
			}
		}
		
		bfs(tl - 1);
	}
	
	public static void expand(int y, int x) {
		for(int i = 0; i < 4; i++) {
			check(y + ry[i], x + rx[i], graph[y][x].life);
		}
	}
	
	public static void check(int y, int x, int life) {
		if (graph[y][x].life != 0) return;
		
		for (int i = 0; i < 4; i++) {
			Node temp = graph[y+ry[i]][x+rx[i]];
			
			if (temp.isActive && temp.life == temp.curr) {
				if (temp.life > life) {
					return;
				}
			}
		}
		
		graph[y][x] = new Node(life, life+1, true, false);
	}
	
	public static void print(int t) {
		int count = 0;
		
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				if (graph[i][j].isliving) {
					count++;
				}
			}
		}
		
		System.out.println("#"+t+" "+count);
	}
}

class Node {
	int life;
	int curr;
	boolean isliving;
	boolean isActive;
	Node() {
		this.life = 0;
		this.curr = 0;
		this.isliving = false;
		this.isActive = false;
	}
	Node(int life, int curr, boolean isliving, boolean isActive) {
		this.life = life;
		this.curr = curr;
		this.isliving = isliving;
		this.isActive = isActive;
	}
}

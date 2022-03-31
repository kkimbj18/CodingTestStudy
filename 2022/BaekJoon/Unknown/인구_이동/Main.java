package BaekJoon.Unknown.인구_이동;

import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] countryArr;
    static boolean[][] visited;
    static List<List<int[]>> list;

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        countryArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                countryArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while(true) {
            list = new ArrayList<>();
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;

                    List<int[]> l = new ArrayList<>();
                    l.add(new int[] { i, j });
                    dfs(i, j, l);
                    if (l.size() != 1) {
                        list.add(l);
                    }
                }
            }

            if (list.isEmpty()) break;

            communicate();
            count++;
        }
        
        System.out.println(count);
    }
    private static void communicate() {
        for (List<int[]> l: list) {
            int sum = 0;
            int avg = 0;
            for (int[] a: l) {
                sum += countryArr[a[0]][a[1]];
            }
            avg = sum / l.size();
            for (int[] a: l) {
                countryArr[a[0]][a[1]] = avg;
            }
        }
    }
    private static void dfs(int y, int x, List<int[]> l) {
        visited[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int ty = y + dy[d];
            int tx = x + dx[d];

            if (ty < 0 || ty >= N || tx < 0 || tx >= N || visited[ty][tx]) continue;

            int diff = Math.abs(countryArr[y][x] - countryArr[ty][tx]);
            if (diff < L || diff > R) continue;

            l.add(new int[] { ty, tx });
            dfs(ty, tx, l);
        }
    }
    


}

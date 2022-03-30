import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };

    static int N;
    static int M;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while(true) {
            boolean[][] v = new boolean[N][M];

            // System.out.println("-------------"+time+"-------------");

            fillOuter(0, 0, map, v);

            // print(map);

            count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !v[i][j]) {
                        melt(i, j, map, v);
                    }
                }
            }

            time++;

            boolean isLast = true;

            loop1:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        isLast = false;
                        break loop1;
                    }
                }
            }

            if (isLast) {
                System.out.println(time);
                System.out.println(count);
                break;
            }
        }

        
    }

    public static void fillOuter(int y, int x, int[][] map, boolean[][] v) {
        map[y][x] = -1;
        v[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int ty = y + dy[d];
            int tx = x + dx[d];

            if (ty < 0 || tx < 0 || ty >= N || tx >= M || v[ty][tx] || map[ty][tx] == 1) continue;

            fillOuter(ty, tx, map, v);
        }
    }

    public static void melt(int y, int x, int[][] map, boolean[][] v) {
        v[y][x] = true;
        count++;

        if (checkContactOuter(y, x, map)) {
            map[y][x] = 0;
        }

        for (int d = 0; d < 4; d++) {
            int ty = y + dy[d];
            int tx = x + dx[d];

            if (ty < 0 || tx < 0 || ty >= N || tx >= M || v[ty][tx] || map[ty][tx] != 1) continue;

            melt(ty, tx, map, v);
        }
    }

    public static boolean checkContactOuter(int y, int x, int[][] map) {
        for (int d = 0; d < 4; d++) {
            int ty = y + dy[d];
            int tx = x + dx[d];

            if (ty < 0 || tx < 0 || ty >= N || tx >= M) continue;

            if (map[ty][tx] == -1) return true;
        }

        return false;
    }

    public static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

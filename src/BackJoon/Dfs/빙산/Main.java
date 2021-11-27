import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        Loop1:
        while (true) {
            boolean[][] checked = new boolean[N][M];
            int icePartNum = 0;
            int restIceNum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !checked[i][j]) {
                        restIceNum++;
                        if (icePartNum > 0)
                            break Loop1;
                        dfs(i, j, checked);
                        icePartNum++;
                    }
                }
            }

            if (restIceNum == 0) {
                count = 0;
                break;
            }

            count++;
            // printMap(count);
        }

        System.out.println(count);
    }
    
    public static void dfs(int i, int j, boolean[][] checked) {
        if (i < 0 || j < 0 || i >= N || j >= M || map[i][j] == 0 || checked[i][j])
            return;

        checked[i][j] = true;

        for (int a = 0; a < 4; a++) {
            if (isMelt(i + dy[a], j + dx[a], checked)) {
                map[i][j]--;
                if (map[i][j] == 0)
                    break;
            }
        }

        for (int a = 0; a < 4; a++) {
            dfs(i + dy[a], j + dx[a], checked);
        }
    }
    
    public static boolean isMelt(int i, int j, boolean[][] checked) {
        if (map[i][j] == 0 && !checked[i][j])
            return true;

        return false;
    }

    public static void printMap(int count) {
        System.out.println(count);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

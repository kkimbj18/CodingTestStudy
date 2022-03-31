package BaekJoon.Unknown.색종이2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int S = 101;
    static boolean[][] visited = new boolean[S][S];
    static boolean[][] checked = new boolean[S][S];

    static int[] dy = { 0, -1, 0, 1 };
    static int[] dx = { -1, 0, 1, 0 };

    static int perimeter;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int xd = Integer.parseInt(st.nextToken());
            int yd = Integer.parseInt(st.nextToken());

            for (int y = yd; y < yd + 10; y++) {
                for (int x = xd; x < xd + 10; x++) {
                    visited[y][x] = true;
                }
            }
        }

        for (int y = 0; y < S; y++) {
            for (int x = 0; x < S; x++) {
                if (visited[y][x] && !checked[y][x]) calPerimeter(y, x);
            }
        }

        System.out.println(perimeter);
    }

    public static void calPerimeter(int y, int x) {
        if (!visited[y][x] || checked[y][x]) return;

        checked[y][x] = true;
        int count = count(y, x);
        if (count == 0) return;

        perimeter += count;

        for (int d = 0; d < 4; d++) {
            int ty = y + dy[d];
            int tx = x + dx[d];

            if (ty < 0 || tx < 0 || ty >= S || tx >= S) continue;

            calPerimeter(ty, tx);
        }
    }

    public static int count(int y, int x) {
        int count = 0;

        for (int d = 0; d < 4; d++) {
            int ty = y + dy[d];
            int tx = x + dx[d];

            if (ty < 0 || tx < 0 || ty >= S || tx >= S || !visited[ty][tx]) {
                count++;
            }
        }

        return count;
    }
}

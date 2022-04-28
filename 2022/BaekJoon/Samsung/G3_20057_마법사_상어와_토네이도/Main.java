import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { -1, 0, 1, 0 };

    static int N;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int len = 1;
        int y = N/2;
        int x = N/2;

        loop1:
        while (true) {
            int d = 0;

            for (int i = 0; i < len; i++) {
                if (x == 0 && y == 0) break loop1;

                x += dx[d];
                y += dy[d];
                spreadSand(d, y, x, map);
            }
            d++;
            for (int i = 0; i < len; i++) {
                x += dx[d];
                y += dy[d];
                spreadSand(d, y, x, map);
            }
            d++;
            len++;
            for (int i = 0; i < len; i++) {
                x += dx[d];
                y += dy[d];
                spreadSand(d, y, x, map);
            }
            d++;
            for (int i = 0; i < len; i++) {
                x += dx[d];
                y += dy[d];
                spreadSand(d, y, x, map);
            }
            d++;
            len++;
        }

        System.out.println(answer);
    }

    public static void spreadSand(int d, int y, int x, int[][] map) {
        int rest = map[y][x];
        int sand;

        if (d % 2 == 0) {
            for (int i = -1; i <= 1; i+=2) {
                int ty = y + i;
                int tx = x - dx[d];

                sand = map[y][x] / 100;
                rest -= sand;

                if (!check(ty, tx)) answer += sand;
                else map[ty][tx] += sand;

                tx += dx[d];

                sand = (map[y][x] * 7 / 100);
                rest -= sand;

                if (!check(ty, tx)) answer += sand;
                else map[ty][tx] += sand;

                ty += i;

                sand = (map[y][x] / 50);
                rest -= sand;

                if (!check(ty, tx)) answer += sand;
                else map[ty][tx] += sand;

                ty -= i;
                tx += dx[d];

                sand = (map[y][x] / 10);
                rest -= sand;

                if (!check(ty, tx)) answer += sand;
                else map[ty][tx] += sand;
            }

            int tx = x + 2*dx[d];
            int ty = y;

            sand = (map[y][x] / 20);
            rest -= sand;

            if (!check(ty, tx)) answer += sand;
            else map[ty][tx] += sand;

            tx -= dx[d];

            sand = rest;

            if (!check(ty, tx)) answer += sand;
            else map[ty][tx] += sand;
        } else {
            for (int i = -1; i <= 1; i+=2) {
                int ty = y - dy[d];
                int tx = x + i;

                sand = map[y][x] / 100;
                rest -= sand;

                if (!check(ty, tx)) answer += sand;
                else map[ty][tx] += sand;

                ty += dy[d];

                sand = (map[y][x] * 7 / 100);
                rest -= sand;

                if (!check(ty, tx)) answer += sand;
                else map[ty][tx] += sand;

                tx += i;

                sand = (map[y][x] / 50);
                rest -= sand;

                if (!check(ty, tx)) answer += sand;
                else map[ty][tx] += sand;

                tx -= i;
                ty += dy[d];

                sand = (map[y][x] / 10);
                rest -= sand;

                if (!check(ty, tx)) answer += sand;
                else map[ty][tx] += sand;
            }

            int tx = x;
            int ty = y + 2*dy[d];

            sand = (map[y][x] / 20);
            rest -= sand;

            if (!check(ty, tx)) answer += sand;
            else map[ty][tx] += sand;

            ty -= dy[d];

            sand = rest;

            if (!check(ty, tx)) answer += sand;
            else map[ty][tx] += sand;
        }
    }

    public static boolean check(int y, int x) {
        if (y < 0 || x < 0 || y >= N || x >= N) return false;

        return true;
    }
}

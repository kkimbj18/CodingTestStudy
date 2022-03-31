import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    static int[] kdy = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] kdx = { 1, 2, 2, 1, -1, -2, -2, -1 };

    static int N;
    static int M;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] v = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(v[i], -1);

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<P> q = new LinkedList<>();
        q.offer(new P(0, 0, K));

        boolean isGoal = false;
        int step = 0;

        loop1:
        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                P p = q.poll();
                if (p.y == N-1 && p.x == M-1) {
                    isGoal = true;
                    break loop1;
                }

                if (p.k > 0) {
                    for (int d = 0; d < 8; d++){
                        int ty = p.y + kdy[d];
                        int tx = p.x + kdx[d];
                        int tk = p.k-1;

                        if (!check(ty, tx, tk, map, v)) continue;

                        v[ty][tx] = tk;
                        q.offer(new P(ty, tx, tk));
                    }
                }

                for (int d = 0; d < 4; d++) {
                    int ty = p.y + dy[d];
                    int tx = p.x + dx[d];

                    if (!check(ty, tx, p.k, map, v)) continue;

                    v[ty][tx] = p.k;
                    q.offer(new P(ty, tx, p.k));
                }
            }

            step++;
        }

        System.out.println(isGoal ? step : -1);
    }

    private static boolean check(int y, int x, int k, int[][] map, int[][] v) {
        if (y < 0 || x < 0 || y >= N || x >= M || map[y][x] == 1 || v[y][x] >= k) return false;

        return true;
    }
}

class P {
    int y;
    int x;
    int k;

    P(int y, int x, int k) {
        this.y = y;
        this.x = x;
        this.k = k;
    }
}

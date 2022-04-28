import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    // 하, 우, 상, 좌
    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    static int[][] dArr = {
        {},
        { 0, 1, 2, 3 },
        { 0, 2 },
        { 1, 3 },
        { 1, 2 },
        { 0, 1 },
        { 0, 3 },
        { 2, 3 }
    };
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            boolean[][] v = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<P> q = new LinkedList<>();
            v[R][C] = true;
            q.add(new P(R, C));
            int time = 0;
            int answer = 0;

            while(!q.isEmpty()) {
                if (time++ == L) break;
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    P p = q.poll();
                    answer++;

                    int dirIdx = map[p.y][p.x];
                    for (int d: dArr[dirIdx]) {
                        int ty = p.y + dy[d];
                        int tx = p.x + dx[d];

                        if (ty < 0 || tx < 0 || ty >= N || tx >= M) continue;
                        if (map[ty][tx] == 0 || v[ty][tx]) continue;
                        if (!checkNextPipe(ty, tx, p.y, p.x, d, map)) continue;

                        v[ty][tx] = true;
                        q.add(new P(ty, tx));
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
    private static boolean checkNextPipe(int ty, int tx, int y, int x, int d, int[][] map) {
        int targetD = (d+2)%4;
        int tdIdx = map[ty][tx];

        for (int td: dArr[tdIdx]) {
            if (targetD == td) return true;
        }

        return false;
    }
}

class P {
    int y;
    int x;

    P(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

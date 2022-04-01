import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = 1;

        while(true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] map = new int[N][N];
            int[][] dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<P> q = new LinkedList<>();
            dp[0][0] = map[0][0];
            q.offer(new P(0, 0));

            while(!q.isEmpty()) {
                P p = q.poll();

                // System.out.println(p);

                for (int d = 0; d < 4; d++) {
                    int ty = p.y + dy[d];
                    int tx = p.x + dx[d];

                    if (ty < 0 || tx < 0 || ty >= N || tx >= N) continue;

                    int curr = dp[p.y][p.x] + map[ty][tx];
                    // System.out.println(ty + " " + tx + ": " + p.v + " " + map[ty][tx] + " " + curr);
                    if (curr >= dp[ty][tx]) continue;

                    dp[ty][tx] = curr;
                    q.offer(new P(ty, tx));
                }

                // print(dp);
            }

            int answer = dp[N-1][N-1];

            sb.append("Problem ").append(t).append(": ").append(answer).append("\n");

            t++;
        }

        System.out.print(sb);
    }

    public static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
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

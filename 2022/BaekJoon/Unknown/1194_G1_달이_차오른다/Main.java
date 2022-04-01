import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static int MAX_FLAG = 1 << 6;

    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        char[][] map = new char[N][M];
        int[][][] dp = new int[N][M][MAX_FLAG];

        P startPos = null;

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == '0') {
                    startPos = new P(i, j, 0, 0);
                    map[i][j] = '.';
                }
            }
        }

        PriorityQueue<P> pq = new PriorityQueue<>();
        pq.offer(startPos);
        dp[startPos.y][startPos.x][0] = 0;
        int answer = -1;

        while(!pq.isEmpty()) {
            P p = pq.poll();

            if (map[p.y][p.x] == '1') {
                answer = p.v;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int ty = p.y + dy[d];
                int tx = p.x + dx[d];
                int tflag = p.flag;

                if (ty < 0 || tx < 0 || ty >= N || tx >= M || map[ty][tx] == '#') continue;

                if (map[ty][tx] >= 'a') {
                    // System.out.println("Before getKey: " + ty + " " + tx + " " + tflag + " " + (p.v+1));
                    tflag |= 1 << (map[ty][tx] - 'a');
                    // System.out.println("After getKey: " + ty + " " + tx + " " + tflag + " " + (p.v+1));
                } else if (map[ty][tx] >= 'A') {
                    // System.out.println("Before useKey: " + ty + " " + tx + " " + tflag + " " + (p.v+1));
                    if ((tflag & 1 << (map[ty][tx] - 'A')) < 1) continue;
                    // System.out.println("After getKey: " + ty + " " + tx + " " + tflag + " " + (p.v+1));
                }

                int curr = p.v + 1;
                if (curr >= dp[ty][tx][tflag]) continue;
                dp[ty][tx][tflag] = curr;

                pq.offer(new P(ty, tx, curr, tflag));
            }
        }

        System.out.println(answer);
    }
}

class P implements Comparable<P> {
    int y;
    int x;
    int v;
    int flag;

    P(int y, int x, int v, int flag) {
        this.y = y;
        this.x = x;
        this.v = v;
        this.flag = flag;
    }

    @Override
    public int compareTo(P o) {
        return Integer.compare(this.v, o.v);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {

    static int MAX = 201;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;
            int x2 = Integer.parseInt(st.nextToken()) + 100;
            int y2 = Integer.parseInt(st.nextToken()) + 100;

            boolean[][][] v = new boolean[MAX][MAX][2];
            Queue<P> q = new LinkedList<>();
            q.offer(new P(y1, x1, 0));
            q.offer(new P(y1, x1, 1));
            int step = 0;

            loop1:
            while(!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    P p = q.poll();
                    if (p.y == y2 && p.x == x2) {
                        break loop1;
                    }

                    int d = (p.d + 1) % 2;
                    for (int td = d; td < 4; td+=2) {
                        int ty = p.y + dy[td];
                        int tx = p.x + dx[td];

                        if (ty < 0 || tx < 0 || ty >= MAX || tx >= MAX || v[ty][tx][d]) continue;

                        v[ty][tx][d] = true;
                        q.offer(new P(ty, tx, d));
                    }
                }

                step++;
            }

            sb.append("#").append(t).append(" ").append(step).append("\n");
        }

        System.out.print(sb);
    }
}

class P {
    int y;
    int x;
    int d;

    P(int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}

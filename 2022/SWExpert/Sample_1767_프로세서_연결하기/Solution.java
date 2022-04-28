import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N;

    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    static int minLen = Integer.MAX_VALUE;
    static int maxCnt = Integer.MIN_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            List<P> cores = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        if (i == 0 || i == N-1 || j == 0 || j == N-1) continue;
                        cores.add(new P(i, j));
                    }
                }
            }

            dfs(0, 0, 0, cores, map);
            sb.append("#").append(t).append(" ").append(minLen).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int idx, int coreCnt, int totalLen, List<P> cores, int[][] map) {
        // System.out.println(idx + ": " + coreCnt + " " + totalLen + " " + maxCnt + " " + minLen);
        if (coreCnt > maxCnt) {
            minLen = totalLen;
            maxCnt = coreCnt;
        } else if (coreCnt == maxCnt && totalLen < minLen) minLen = totalLen;

        if (cores.size() == idx) return;

        P core = cores.get(idx);

        for (int d = 0; d < 4; d++) {
            int[][] newMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                newMap[i] = map[i].clone();
            }

            int len = 0;
            int ty = core.y;
            int tx = core.x;

            while(true) {
                ty += dy[d];
                tx += dx[d];

                if (ty < 0 || tx < 0 || ty >= N || tx >= N) break;
                if (map[ty][tx] == 1) {
                    len = 0;
                    break;
                }
                
                len++;
                newMap[ty][tx] = 1;
            }

            if (len == 0) dfs(idx+1, coreCnt, totalLen, cores, map);
            else dfs(idx+1, coreCnt+1, totalLen+len, cores, newMap);
        }
    }
}

class P {
    int y;
    int x;
    P (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

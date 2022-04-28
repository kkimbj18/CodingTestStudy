import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int INF = 987654321;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[][] adj = new int[N+1][N+1];

            for (int i = 0; i <= N; i++) {
                Arrays.fill(adj[i], INF);
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int lower = Integer.parseInt(st.nextToken());
                int higher = Integer.parseInt(st.nextToken());
                adj[lower][higher] = 1;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
                    }
                }
            }
 
            int[] reachable = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (adj[i][j] != INF) {
                        reachable[i]++;
                        reachable[j]++;
                    }
                }
            }
            
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (reachable[i] == N-1) {
                    answer++;
                }
            }
 
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] graph;
    static int N, M;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        sc.close();

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j) == true)
                    count++;
            }
        }
        
        System.out.println(count);
    }
    
    public static boolean dfs(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return false;
        }
        if (graph[r][c] == 1) {
            return false;
        }

        graph[r][c] = 1;

        System.out.println("r:"+r+"c:"+c);

        dfs(r - 1, c);
        dfs(r + 1, c);
        dfs(r, c - 1);
        dfs(r, c + 1);

        return true;
    }
}

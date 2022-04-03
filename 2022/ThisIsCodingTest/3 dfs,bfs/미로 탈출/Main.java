import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] graph;
    static int min = 9999999;

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

        dfs(1, 0, 0);

        System.out.println(min);
    }
    
    public static void dfs(int count, int x, int y) {
        if (min < count)
            return;
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }
        if (graph[y][x] == 0)
            return;

        if (x == M - 1 && y == N - 1) {
            if (min > count) {
                System.out.println("x:" + x + "y:" + y + "count:" + count);
                min = count;

                return;
            }
        }
        
        count++;
        
        dfs(count, x + 1, y);
        dfs(count, x, y + 1);
    }
}

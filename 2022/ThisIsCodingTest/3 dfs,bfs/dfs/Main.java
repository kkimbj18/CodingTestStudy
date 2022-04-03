import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] graph = {
            {},
            {2,3,8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}
        };
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited, false);

        dfs(1, graph, visited);

        System.out.println();
    }

    public static void dfs(int v, int[][] graph, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < graph[v].length; i++) {
            if (!visited[graph[v][i]]) {
                dfs(graph[v][i], graph, visited);
            }
        }
    }
}

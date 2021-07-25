import java.util.*;

public class Main {

    public static int[][] graph = {
            {},
            { 2, 3, 8 },
            { 1, 7 },
            { 1, 4, 5 },
            { 3, 5 },
            { 3, 4 },
            { 7 },
            { 2, 6, 8 },
            { 1, 7 } 
    };

    public static void main(String[] args) {
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited, false);

        bfs(1, visited);
    }
    
    public static void bfs(int v, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visited[v] = true;

        while (q.size() > 0) {
            int e = q.poll();
            System.out.println(e + " ");
            for (int i = 0; i < graph[e].length; i++) {
                if (!visited[graph[e][i]]) {
                    q.add(graph[e][i]);
                    visited[graph[e][i]] = true;
                }
            }
        }
    }
}
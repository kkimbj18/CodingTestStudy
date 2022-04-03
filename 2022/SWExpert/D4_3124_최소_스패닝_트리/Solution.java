import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            boolean[] v = new boolean[V+1];
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            List<Edge>[] edges = new ArrayList[V+1];
            for (int i = 1; i <= V; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edges[from].add(new Edge(to, weight));
                edges[to].add(new Edge(from, weight));
            }

            int count = 0;
            long answer = 0;
            pq.offer(new Edge(1, 0));

            while(!pq.isEmpty()) {
                Edge e = pq.poll();

                if (v[e.to]) continue;
                v[e.to] = true;
                answer += e.weight;
                if (++count == V) break;

                for (Edge ee: edges[e.to]) {
                    if (v[ee.to]) continue;

                    pq.offer(ee);
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}

class Edge implements Comparable<Edge> {
    int to;
    int weight;

    Edge(int t, int w) {
        to = t;
        weight = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
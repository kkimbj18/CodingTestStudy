package BaekJoon.Unknown.네트워크_연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int[] p;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            pq.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int cost = 0;

        makeSet();

        while(!pq.isEmpty()) {
            Edge e = pq.poll();

            if (union(e.v1, e.v2)) continue;

            cost += e.w;
        }

        System.out.println(cost);
    }

    private static void makeSet() {
        p = new int[N+1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;

        p[y] = x;
        return false;
    }

    private static int find(int x) {
        if (p[x] == x) return x;

        return p[x] = find(p[x]);
    }
}

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int w;

    Edge(int v1, int v2, int w) {
        this.v1 = v1;
        this.v2 = v2;
        this.w = w;
    }

    @Override
    public int compareTo(Edge e) {
        return this.w - e.w;
    }

    @Override
    public String toString() {
        return "Edge [v1=" + v1 + ", v2=" + v2 + ", w=" + w + "]";
    }
}

import java.util.*;

class Solution {

    public int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<Integer>[] list = new ArrayList[n];
        int[] count = new int[n];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            list[edge[i][0] - 1].add(edge[i][1] - 1);
            list[edge[i][1] - 1].add(edge[i][0] - 1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        count[0] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int e : list[now]) {
                if (count[e] <= count[now] + 1)
                    continue;

                count[e] = count[now] + 1;
                q.add(e);
            }
        }

        int maxValue = Arrays.stream(count).max().getAsInt();

        for (int i = 0; i < n; i++) {
            if (maxValue == count[i]) {
                answer++;
            }
        }

        return answer;
    }
}
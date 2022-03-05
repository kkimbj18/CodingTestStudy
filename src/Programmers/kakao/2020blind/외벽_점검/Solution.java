class Solution {

    int n;
    int[] weak;
    int[] dist;
    int[][] weakCases;
    int[] tempDist;

    int count = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {

        this.n = n;
        this.weak = weak;
        this.dist = dist;
        tempDist = new int[dist.length];

        makeAllWeakCases();
        perm(0, new boolean[dist.length]);

        return (count == Integer.MAX_VALUE) ? -1 : count;
    }

    private void perm(int cnt, boolean[] v) {
        if (cnt == dist.length) {
            check();
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (v[i]) continue;

            v[i] = true;
            tempDist[cnt] = dist[i];
            perm(cnt+1, v);
            v[i] = false;
        }
    }

    private void check() {
        for (int[] weakCase: weakCases) {
            int curr = 0;
            int next = 0;
            int distIdx = 0;

            while (distIdx < dist.length) {
                next = curr+1;
                while (next < weak.length && tempDist[distIdx] >= weakCase[next] - weakCase[curr]) next++;
                curr = next;

                distIdx++;
                
                if (curr == weak.length) {
                    count = Math.min(count, distIdx);
                    break;
                }
            }
        }
    }

    private void makeAllWeakCases() {
        weakCases = new int[weak.length][weak.length];

        for (int i = 0; i < weak.length; i++) {
            int index = i-1;
            int base = 0;

            for (int j = 0; j < weak.length; j++) {
                index++;
                if (index == weak.length) {
                    base = n;
                    index = 0;
                }
                weakCases[i][j] = base + weak[index];
            }
        }
    }
}
import java.util.*;

public class Solution2 {

    static int N;
    static int D;
    static int[] weak;
    static int[] dist;
    static boolean repaired;

    public int solution(int n, int[] weak, int[] dist) {
        Solution2.N = n;
        Solution2.dist = dist;
        Solution2.weak = weak;
        D = dist.length;
        Arrays.sort(dist);

        boolean[] v = new boolean[weak.length];
        for (int i = 1; i <= dist.length; i++) {
            for (int j = 0; j < weak.length; j++) {
                dfs(i, j, v);
                if (repaired) return i;
            }
        }

        return -1;
    }

    private void dfs(int i, int j, boolean[] vv) {
        if (i == 0) {
            if (checkAllRepaired(vv)) repaired = true;

            return;
        } 
        if (vv[j]) return;

        int rest = dist[D-i];
        int prev = weak[j];
        int index = j;
        boolean[] v = vv.clone();
        v[j] = true;

        while(true) {
            index = index+1;
            int target;

            if (index == weak.length) {
                index = 0;
                target = N + weak[index];
            } else target = weak[index];

            if (v[index]) {
                if (checkAllRepaired(v)) repaired = true;

                return;
            }

            rest -= target - prev;
            if (rest < 0) break;

            prev = weak[index];
            v[index] = true;
        }

        for (int a = 0; a < weak.length; a++) {
            dfs(i-1, a, v);
        }
    }

    public boolean checkAllRepaired(boolean[] v) {
        for (boolean vv: v) {
            if (!vv) return false;
        }

        return true;
    }
}
import java.util.*;

class Solution {
    int answer;
    int N;
    int M;
    int K;

    int[] dy = { 1, 0, -1, 0 };
    int[] dx = { 0, 1, 0, -1 };

    List<P> locs;
    char[] chars;
    String[] grid;

    public int solution(String[] grid) {
        answer = 0;
        this.grid = grid;

        findLocs();
        comb(0);

        return answer;
    }

    private void comb(int cnt) {
        if (cnt == K) {
            answer++;

            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (!checkValid(c, cnt)) continue;

            chars[cnt] = c;
            comb(cnt+1);
        }
    }

    private boolean checkValid(char c, int cnt) {
        boolean[][] v = new boolean[N][M];
        int[] count = new int[3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (v[i][j]) continue;

                char ch = getChar(i, j, cnt, grid[i].charAt(j), c);
                if (ch < 'a' || ch > 'c') continue;

                count[ch-'a']++;
                if (count[ch-'a'] > 1) return false;

                dfs(i, j, ch, c, cnt, v);
            }
        }

        return true;
    }

    private void dfs(int y, int x, char target, char c, int cnt, boolean[][] v) {
        v[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int ty = y + dy[d];
            int tx = x + dx[d];

            if (ty < 0 || tx < 0 || ty >= N || tx >= M || v[ty][tx]) continue;

            char ch = getChar(ty, tx, cnt, c, target);
            if (ch != target) continue;

            dfs(ty, tx, target, c, cnt, v);
        }
    }

    private char getChar(int y, int x, int cnt, char c, char target) {
        char ch = grid[y].charAt(x);

        if (ch == '?') {
            int idx = locs.indexOf(new P(y, x));

            if (idx < cnt) {
                ch = chars[idx];
            } else if (idx == cnt) ch = c;
            else ch = target;
        }

        return ch;
    }

    public void findLocs() {
        locs = new ArrayList<>();

        N = grid.length;
        M = grid[0].length();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '?') locs.add(new P(i, j));
            }
        }

        K = locs.size();
        chars = new char[K];
    }
}

class P {
    int y;
    int x;

    P(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        P other = (P) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
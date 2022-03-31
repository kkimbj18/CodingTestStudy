import java.util.*;
import java.io.*;

public class UnionFind {
    static char[][] lake;
    static int[] parent;
    static int[][] parentPos;
    static int R;
    static int C;
    static int[][] loc = new int[2][2];
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    static Queue<Integer[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        lake = new char[R][C];
        parent = new int[R * C];
        parentPos = new int[R][C];

        int answer = 0;
        int locCount = 0;

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                lake[i][j] = temp.charAt(j);

                parentPos[i][j] = i * C + j;
                parent[parentPos[i][j]] = parentPos[i][j];

                if (lake[i][j] != 'X') {
                    if (lake[i][j] == 'L') {
                        loc[locCount][0] = i;
                        loc[locCount][1] = j;
                        locCount++;
                    }
                    merge(i, j);
                }
            }
        }

        while (!q.isEmpty()) {
            answer++;

            melt();

            if (check()) {
                break;
            }
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    public static void merge(int y, int x) {
        Integer[] temp = { y, x };
        lake[y][x] = '.';
        q.add(temp);
        int w = find(parentPos[y][x]);
        
        for (int i = 0; i < 4; i++) {
            int ty = y + dy[i];
            int tx = x + dx[i];

            if (tx < 0 || ty < 0 || tx >= C || ty >= R)
                continue;

            if (lake[ty][tx] == '.') {
                int v = find(parentPos[ty][tx]);
                if (v != w)
                    parent[v] = w;
            }
        }
    }
    
    public static void melt() {
        int len = q.size();

        for (int i = 0; i < len; i++) {
            Integer[] temp = q.poll();

            for (int d = 0; d < 4; d++) {
                int ty = temp[0] + dy[d];
                int tx = temp[1] + dx[d];

                if (tx < 0 || ty < 0 || tx >= C || ty >= R)
                    continue;
                if (lake[ty][tx] == 'X')
                    merge(ty, tx);
            }
        }
    }

    public static boolean check() {
        if (find(parentPos[loc[0][0]][loc[0][1]]) == find(parentPos[loc[1][0]][loc[1][1]])) {
            return true;
        }

        return false;
    }
}

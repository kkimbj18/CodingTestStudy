import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Dfs2 {
    static char[][] lake;
    static int[][] ice;
    static int[][] ice2;
    static int R;
    static int C;
    static int[] loc = new int[2];
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        lake = new char[R][C];
        ice = new int[R][C];
        ice2 = new int[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            int locTemp = temp.indexOf("L");
            if (locTemp != -1) {
                loc[0] = i;
                loc[1] = locTemp;
            }

            lake[i] = temp.toCharArray();
        }

        boolean[][] checked = new boolean[R][C];

        dfs(0, 0, 0, checked);
        check(loc[0], loc[1], 0, new boolean[R][C], 0);

        System.out.println(min);
    }
    
    public static void dfs(int y, int x, int count, boolean[][] checked) {
        if (y < 0 || x < 0 || y >= R || x >= C)
            return;
        if (count >= ice[y][x] && checked[y][x])
            return;

        checked[y][x] = true;

        if (lake[y][x] == 'X')
            count++;
        else {
            count = 0;
        }

        ice[y][x] = count;
        
        for (int i = 0; i < 4; i++) {
            dfs(y + dy[i], x + dx[i], count, checked);
        }
    }

    public static void check(int y, int x, int maxIce, boolean[][] checked, int LCount) {
        if (maxIce >= min)
            return;
        if (y < 0 || x < 0 || y >= R || x >= C)
            return;
        if (checked[y][x] && maxIce >= ice2[y][x])
            return;
        if (lake[y][x] == 'L') {
            LCount++;

            if (LCount == 2) {
                if (min > maxIce)
                    min = maxIce;

                return;
            }
        }

        checked[y][x] = true;

        if (ice[y][x] > maxIce) {
            maxIce = ice[y][x];
        }
        ice2[y][x] = maxIce;

        for (int i = 0; i < 4; i++) {
            check(y + dy[i], x + dx[i], maxIce, checked, LCount);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs {
    static int R;
    static int C;
    static char[][] lake;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    static int[] target = new int[2];
    static boolean checkBool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        lake = new char[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();

            int locTemp = temp.indexOf("L");
            if (locTemp != -1) {
                target[0] = i;
                target[1] = locTemp;
            }

            lake[i] = temp.toCharArray();
        }

        while (true) {
            answer++;

            boolean[][] checked = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    dfs(i, j, checked);
                }
            }

            check(target[0], target[1], new boolean[R][C], 0);

            if (checkBool)
                break;
        }
        
        System.out.println(answer);
    }
    
    public static void dfs(int y, int x, boolean[][] checked) {
        if (x < 0 || y < 0 || x >= C || y >= R)
            return;
        if (checked[y][x] || lake[y][x] == 'X')
            return;

        checked[y][x] = true;

        melt(y, x, checked);

        for (int i = 0; i < 4; i++) {
            dfs(y + dy[i], x + dx[i], checked);
        }
    }

    public static void melt(int y, int x, boolean[][] checked) {
        for (int i = 0; i < 4; i++) {
            int ty = y + dy[i];
            int tx = x + dx[i];

            if (tx < 0 || ty < 0 || tx >= C || ty >= R)
                continue;

            if (lake[ty][tx] == 'X' && !checked[ty][tx]) {
                lake[ty][tx] = '.';
                checked[ty][tx] = true;
            }
        }
    }

    public static void check(int y, int x, boolean[][] checked, int count) {
        if (checkBool)
            return;
        if (x < 0 || y < 0 || x >= C || y >= R)
            return;
        if (checked[y][x] || lake[y][x] == 'X')
            return;
        if (lake[y][x] == 'L') {
            count++;

            if (count == 2) {
                checkBool = true;
                return;
            }
        }

        checked[y][x] = true;

        for (int i = 0; i < 4; i++) {
            check(y + dy[i], x + dx[i], checked, count);
        }
    }
}

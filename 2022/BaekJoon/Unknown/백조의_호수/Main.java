import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {
    static char[][] lake;
    static int[][] ice;
    static int R;
    static int C;
    static int[][] loc = new int[2][2];
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        max = Math.max(R, C);

        lake = new char[R][C];
        ice = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(ice[i], max);
        }

        int locCount = 0;

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            int locTemp = temp.indexOf("L");
            if (locTemp != -1) {
                loc[locCount][0] = i;
                loc[locCount][1] = locTemp;
                locCount++;
            }

            lake[i] = temp.toCharArray();
        }

        Queue<Integer[]> q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (lake[i][j] != 'X') {
                    ice[i][j] = 0;

                    for (int k = 0; k < 4; k++) {
                        int ty = i + dy[k];
                        int tx = j + dx[k];

                        if (ty < 0 || tx < 0 || ty >= R || tx >= C)
                            continue;

                        if (lake[ty][tx] == 'X') {
                            Integer[] temp = { ty, tx };
                            ice[ty][tx] = 1;

                            q.add(temp);
                        }
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Integer[] item = q.poll();

            for (int i = 0; i < 4; i++) {
                int ty = item[0] + dy[i];
                int tx = item[1] + dx[i];

                if (ty < 0 || tx < 0 || ty >= R || tx >= C)
                    continue;

                if (lake[ty][tx] == 'X') {
                    if (ice[item[0]][item[1]] + 1 >= ice[ty][tx])
                        continue;

                    Integer[] temp = { ty, tx };
                    ice[ty][tx] = ice[item[0]][item[1]] + 1;

                    q.add(temp);
                }
            }
        }

        int left = 0;
        int right = max;
        int mid = 0;
        int lastHit = mid;
        Integer[] temp = { loc[0][0], loc[0][1] };
        while (left <= right) {
            mid = (left + right) / 2;

            boolean[][] checked = new boolean[R][C];
            boolean isLExist = false;
            checked[temp[0]][temp[1]] = true;
            q.clear();
            q.add(temp);

            Loop1: 
            while (!q.isEmpty()) {
                Integer[] item = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ty = item[0] + dy[i];
                    int tx = item[1] + dx[i];

                    if (ty < 0 || tx < 0 || ty >= R || tx >= C || checked[ty][tx])
                        continue;
                    if (lake[ty][tx] == 'L') {
                        isLExist = true;
                        break Loop1;
                    }

                    checked[ty][tx] = true;

                    if (ice[ty][tx] <= mid) {
                        Integer[] temp2 = { ty, tx };

                        q.add(temp2);
                    }
                }
            }

            if (isLExist) {
                right = mid - 1;
                lastHit = mid;
            } else  left = mid + 1;
        }

        System.out.println(lastHit);
    }
}

package BaekJoon.Unknown.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M];

        Queue<RTomato> q = new LinkedList<>();

        int total = N * M;
        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.add(new RTomato(i, j));
                    count++;
                } else if (box[i][j] == -1) {
                    total--;
                }
            }
        }

        int level = 0;
        int prevC = count;

        while (true) {

            if (count == total) break;

            int size = q.size();

            while(--size >= 0) {
                RTomato rt = q.poll();

                for (int d = 0; d < 4; d++) {
                    int ty = rt.y + dy[d];
                    int tx = rt.x + dx[d];

                    if (ty < 0 || tx < 0 || ty >= N || tx >= M) continue;

                    if (box[ty][tx] == 0) {
                        q.add(new RTomato(ty, tx));
                        box[ty][tx] = 1;
                        count++;
                    }
                }
            }

            if (count == prevC) {
                level = -1;
                break;
            }

            prevC = count;
            
            level++;
        }

        System.out.println(level);
    }
}

class RTomato {
    int y;
    int x;

    RTomato(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

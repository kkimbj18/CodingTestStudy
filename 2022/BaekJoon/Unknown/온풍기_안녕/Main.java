package BaekJoon.Unknown.온풍기_안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // 오, 왼, 위, 아래
    static int[] dy = { 1, 0, -1, -1, -1, 0, 1, 1 };
    static int[] dx = { 1, 1, 1, 0, -1, -1, -1, 0 };

    static int[][] map;
    static int[][] wall;
    static boolean[][] v;

    // 오, 아래, 왼, 위
    static int[] ddy = { 0, 1, 0, -1 };
    static int[] ddx = { 1, 0, -1, 0 };

    // 오, 왼, 위, 아래
    static int[] hdy = { 0, 0, -1, 1 };
    static int[] hdx = { 1, -1, 0, 0 };

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        wall = new int[N][M];

        List<H> heater = new ArrayList<>();
        List<P> target = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > 0) {
                    if (num == 5) target.add(new P(i, j));
                    else heater.add(new H(i, j, num-1));
                }
            }
        }

        int W = Integer.parseInt(br.readLine());

        // 벽 위, 오
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken()) + 1;
            wall[y][x] = t;
        }

        int choco = 0;
        while (choco < 101) {
            // 히터 바람 보내기
            for (H heat: heater) {
                v = new boolean[N][M];
                int ty = heat.y + hdy[heat.d];
                int tx = heat.x + hdx[heat.d];
                map[ty][tx] += 5;
                dfs(ty, tx, heat.d, 4);
            }
            print(choco+1);
            // 온도 조절
            cycle();
            print(choco+1);
            // 바깥 온도 1 감소
            int y = 0;
            int x = 0;
            int d = 0;
            while(true) {
                int ty = y + ddy[d];
                int tx = x + ddx[d];

                if (!checkValid(ty, tx)) {
                    // System.out.println(ty + " " + tx + " " + d);
                    if (ty == -1 && tx == 0) break;
                    d++;
                    ty = y + ddy[d];
                    tx = x + ddx[d];
                }

                map[ty][tx] = (map[ty][tx] == 0) ? 0 : map[ty][tx] - 1;
                y = ty;
                x = tx;
            }
            // 초콜릿 먹기
            choco++;
            print(choco);
            // 조사 칸 온도 검사
            if (checkTemp(target, K)) break;
        }

        System.out.println(choco);
    }

    public static void print(int choco) {
        System.out.println(choco);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean checkValid(int y, int x) {
        if (y < 0 || x < 0 || y >= N || x >= M) return false;
        return true;
    }

    private static boolean checkTemp(List<P> target, int K) {
        for (P t: target) {
            if (map[t.y][t.x] < K) return false;
        }

        return true;
    }

    private static void cycle() {
        int[][] nmap = new int[N][M];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 0) continue;

                nmap[y][x] += map[y][x];

                for (int d = 0; d < 4; d++) {
                    int ty = y + ddy[d];
                    int tx = x + ddx[d];
                    if (!checkValid(ty, tx)) continue;
                    if (map[ty][tx] >= map[y][x]) continue;

                    if (ddx[d] == 1 && wall[y][x] == 2) continue;
                    if (ddx[d] == -1 && wall[y][tx] == 2) continue;
                    if (ddy[d] == 1 && wall[ty][x] == 1) continue;
                    if (ddy[d] == -1 && wall[y][x] == 1) continue;

                    int diff = (map[y][x] - map[ty][tx]) / 4;

                    nmap[y][x] -= diff;
                    nmap[ty][tx] += diff;
                }
            }
        }

        map = nmap;
    }

    private static void dfs(int y, int x, int d, int s) {
        if (s == 0) return;

        int td = 0;

        switch(d) {
            case 0: 
                td = -1;
                break;
            case 1: 
                td = 3;
                break;
            case 2: 
                td = 1;
                break;
            case 3: 
                td = 5;
                break;
        }

        for (int i = 0; i < 3; i++) {
            td = (td+1) % 8;

            int ty = y + dy[td];
            int tx = x + dx[td];

            if (!checkValid(ty, tx) || v[ty][tx]) continue;

            // 위, 오
            // 오, 왼, 위, 아래
            if (d == 0) {
                if (dy[td] == 0) {
                    if (wall[y][x] == 2) continue; 
                } else if (dy[td] == 1) {
                    if (wall[ty][x] == 1) continue;
                    if (wall[ty][x] == 2) continue;
                } else {
                    if (wall[y][x] == 1) continue;
                    if (wall[ty][x] == 2) continue;
                }
            } else if (d == 1) {
                if (dy[td] == 0) {
                    if (wall[y][tx] == 2) continue;
                } else if (dy[td] == 1) {
                    if (wall[ty][x] == 1) continue;
                    if (wall[ty][tx] == 2) continue;
                } else {
                    if (wall[y][x] == 1) continue;
                    if (wall[ty][tx] == 2) continue;
                }
            } else if (d == 2) {
                if (dx[td] == 0) {
                    if (wall[y][x] == 1) continue;
                } else if (dx[td] == 1) {
                    if (wall[y][x] == 2) continue;
                    if (wall[y][tx] == 1) continue;
                } else {
                    if (wall[y][tx] == 2) continue;
                    if (wall[y][tx] == 1) continue;
                }
            } else {
                if (dx[td] == 0) {
                    if (wall[ty][x] == 1) continue;
                } else if (dx[td] == 1) {
                    if (wall[y][x] == 2) continue;
                    if (wall[ty][tx] == 1) continue;
                } else {
                    if (wall[y][tx] == 2) continue;
                    if (wall[ty][tx] == 1) continue;
                }
            }

            v[ty][tx] = true;
            map[ty][tx] += s;
            dfs(ty, tx, d, s-1);
        }
    }
}

class P {
    int y;
    int x;

    public P(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class H {
    int y;
    int x;
    int d;

    public H(int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static Grid[][] board;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new Grid[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = new Grid(Integer.parseInt(st.nextToken()), false);
            }
        }

        br.close();

        while (true) {
            count = 0;
            boolean[][] checked = new boolean[N][M];
            checkOuterAir(0, 0, checked);
            if (count == N * M)
                break;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    melt(i, j, checked);
                }
            }

            answer++;
        }

        System.out.println(answer);
    }
    
    public static void checkOuterAir(int y, int x, boolean[][] checked) {
        if (y < 0 || x < 0 || y >= N || x >= M || checked[y][x] || board[y][x].value == 1)
            return;

        checked[y][x] = true;
        board[y][x].isOuter = true;
        count++;

        for (int i = 0; i < 4; i++) {
            checkOuterAir(y + dy[i], x + dx[i], checked);
        }
    }

    public static void melt(int y, int x, boolean[][] checked) {
        if (checked[y][x] || board[y][x].value == 0)
            return;

        checked[y][x] = true;

        int outerAirCount = countOuterAir(y, x);

        if (outerAirCount >= 2)
            board[y][x].value = 0;
    }

    public static int countOuterAir(int y, int x) {
        int count = 0;
        
        for (int i = 0; i < 4; i++) {
            if (board[y + dy[i]][x + dx[i]].isOuter)
                count++;
        }
        
        return count;
    }
}

class Grid {
    int value;
    boolean isOuter;
    
    Grid(int value, boolean isOuter) {
        this.value = value;
        this.isOuter = isOuter;
    }
}

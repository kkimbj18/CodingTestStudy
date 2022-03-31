package BaekJoon.Unknown.알파_틱택토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char target;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = 3;

        int[][] board = new int[N][N];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) cnt++;
                else if (board[i][j] == 2) cnt--;
            }
        }

        if (cnt > 0) target = 2;
        else target = 1;

        int winner = findResult(board, target);

        char result = (winner == target) ? 'W' : (winner == 0) ? 'D' : 'L';

        System.out.println(result);
    }

    private static int findResult(int[][] board, int curr) {
        int result = 3 - curr;

        List<P> list = find(board, curr);
        if (list.isEmpty()) return findWinner(board, 0);
        else {
            int r = findWinner(board, -1);

            // System.out.println(r);

            if (r != -1) return r;
        }

        int r;

        for (P p: list) {

            board[p.y][p.x] = curr;

            r = findResult(board, 3-curr);

            board[p.y][p.x] = 0;

            if (r == curr) return r;

            if (r == 0 && curr != r) result = 0;
        }

        // print(board);
        // System.out.println(result + " " + curr);

        return result;
    }

    private static void print(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int findWinner(int[][] board, int defaultValue) {

        if (board[0][0] != 0 && board[0][0] == board[0][1] && board[0][1] == board[0][2]) return board[0][0];
        if (board[1][0] != 0 && board[1][0] == board[1][1] && board[1][1] == board[1][2]) return board[1][0];
        if (board[2][0] != 0 && board[2][0] == board[2][1] && board[2][1] == board[2][2]) return board[2][0];

        if (board[0][0] != 0 && board[0][0] == board[1][0] && board[1][0] == board[2][0]) return board[0][0];
        if (board[0][1] != 0 && board[0][1] == board[1][1] && board[1][1] == board[2][1]) return board[0][1];
        if (board[0][2] != 0 && board[0][2] == board[1][2] && board[1][2] == board[2][2]) return board[0][2];

        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return board[0][0];
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return board[0][2];

        return defaultValue;
    }

    private static List<P> find(int[][] board, int curr) {
        List<P> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) list.add(new P(i, j));
            }
        }

        return list;
    }
}

class P {
    int y;
    int x;

    P (int y, int x) {
        this.y = y;
        this.x = x;
    }
}


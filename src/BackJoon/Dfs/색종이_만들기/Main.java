import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    static int[] count = { 0, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0, N);

        for (int i = 0; i < 2; i++) {
            System.out.println(count[i]);
        }
    }

    public static void check(int sy, int sx, int size) {
        int color = arr[sy][sx];
        int hSize = size / 2;

        for (int y = sy; y < size + sy; y++) {
            for (int x = sx; x < size + sx; x++) {
                if (arr[y][x] != color) {
                    check(sy, sx, hSize);
                    check(sy, sx + hSize, hSize);
                    check(sy + hSize, sx, hSize);
                    check(sy + hSize, sx + hSize, hSize);

                    return;
                }
            }
        }


        count[color]++;
    }
}

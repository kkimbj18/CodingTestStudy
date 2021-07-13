import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int A = sc.nextInt();
        int B = sc.nextInt();
        int d = sc.nextInt();

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };

        sc.close();

        int count = 0;

        map[A][B] = 2;

        Loop: while (true) {
            int dTemp = d;
            System.out.println(d);

            while (true) {
                dTemp--;
                if (dTemp < 0) {
                    dTemp = 3;
                }
                int target = map[A + dy[dTemp]][B + dx[dTemp]];

                if (target == 1 || target == 2) {
                    if (d == dTemp) {
                        if (dTemp >= 2)
                            dTemp -= 2;
                        else
                            dTemp += 2;

                        if (map[A + dy[dTemp]][B + dx[dTemp]] == 1) {
                            System.out.println("A : " + (A + dy[dTemp]) + "B : " + (B + dx[dTemp]));
                            System.out.println("The End");
                            break Loop;
                        } else {
                            A += dy[dTemp];
                            B += dy[dTemp];
                            count++;
                            break;
                        }
                    }
                    continue;
                } else {
                    map[A + dy[dTemp]][B + dx[dTemp]] = 2;
                    A += dy[dTemp];
                    B += dx[dTemp];
                    count++;
                    d = dTemp;
                    System.out.println("d : " + d);
                    System.out.println("A : " + (A) + "B : " + (B));

                    printMap(N, M, map);

                    break;
                }
            }
        }

        System.out.println(count);
    }
    
    public static void printMap(int N, int M, int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        int[][] num = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                num[i][j] = scan.nextInt();
            }
            Arrays.sort(num[i]);
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            if (num[i][0] > max) {
                max = num[i][0];
            }
        }
        
        System.out.println(max);

        scan.close();
    }
}

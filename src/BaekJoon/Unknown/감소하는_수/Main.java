import java.util.Scanner;

public class Main {
    static int count = -1;
    static int N;
    static long X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        sc.close();

        int digit = 0;

        while (count < N) {
            if (++digit > 10)
                break;
            for (int i = digit - 1; i <= 9; i++) {
                dfs(i, digit, i + "");
                if (count >= N)
                    break;
            }
        }

        if (count < N)
            X = -1;

        System.out.println(X);
    }
    
    public static void dfs(int now, int digit, String str) {
        if (count >= N || now < digit - 1) {
            return;
        }
        if (digit == 1) {
            count++;
            if (count == N) {
                X = Long.parseLong(str);
            }

            return;
        }

        for (int i = 0; i < now; i++) {
            dfs(i, digit - 1, str + i);
        }
    }
}

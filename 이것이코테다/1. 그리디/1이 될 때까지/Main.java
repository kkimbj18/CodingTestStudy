import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;

        while (true) {
            if (N == 1)
                break;

            if (N % K == 0)
                N /= K;
            else
                N -= 1;

            count++;
        }

        System.out.println(count);

        sc.close();
    }
}

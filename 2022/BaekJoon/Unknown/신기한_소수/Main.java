package BaekJoon.Unknown.신기한_소수;

import java.util.Scanner;

public class Main {

    static int MAX;
    static int BASE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.close();

        BASE = (int)Math.pow(10, (N-1));
        MAX = BASE * 10;

        for (int i = BASE; i < MAX; i++) {
            if (!checkComb(i)) System.out.println(i);
        }
    }

    public static boolean checkComb(int i) {
        int d = BASE;

        int temp = i / d;
        if (temp == 2 || temp == 3 || temp == 5 || temp == 7) {
            while (true) {
                d /= 10;
                if (d < 1) break;
                temp = i / d;
                
                for (int j = 2; j <= Math.sqrt(temp); j++) {
                    if (temp % j == 0) return true;
                }
            }
        } else return true;

        return false;
    }
}

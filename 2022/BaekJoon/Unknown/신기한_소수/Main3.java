package BaekJoon.Unknown.신기한_소수;

import java.util.Scanner;

public class Main3 {

    static boolean[] isComb;
    static int MAX;
    static int BASE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.close();

        BASE = (int)Math.pow(10, (N-1));
        MAX = BASE * 10;

        isComb = new boolean[BASE];
        isComb[1] = true;

        for (int i = 2; i < Math.sqrt(BASE); i++) {
            if (isComb[i]) continue;

            fillComb(i);
        }

        for (int i = BASE; i < MAX; i++) {
            if (!checkComb(i)) System.out.println(i);
        }
    }

    public static void fillComb(int i) {
        int temp = i;

        while(true) {
            temp += i;
            if (temp >= BASE) break;

            isComb[temp] = true;
        }
    }

    public static boolean checkComb(int i) {
        int d = BASE;

        while (true) {
            int temp = i / d;
            if (temp >= BASE) break;
            if (isComb[temp]) return true;
            d /= 10;
        }

        for (int j = 2; j < Math.sqrt(i); j++) {
            if (i % j == 0) return true;
        }

        return false;
    }
}

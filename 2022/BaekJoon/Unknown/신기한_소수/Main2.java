package BaekJoon.Unknown.신기한_소수;

import java.util.Scanner;

public class Main2 {

    static boolean[] isComb;
    static int MAX;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.close();

        int base = (int)Math.pow(10, (N-1));
        MAX = base * 10;

        isComb = new boolean[MAX];
        isComb[1] = true;

        for (int i = 2; i < Math.sqrt(MAX); i++) {
            if (isComb[i]) continue;

            fillComb(i);
        }

        for (int i = base; i < MAX; i++) {
            if (!checkComb(i)) System.out.println(i);
        }
    }

    public static void fillComb(int i) {
        int temp = i;

        while(true) {
            temp += i;
            if (temp >= MAX) break;

            isComb[temp] = true;
        }
    }

    public static boolean checkComb(int i) {
        while (true) {
            if (isComb[i]) return true;

            i /= 10;
            if (i < 1) break;
        }

        return false;
    }
}

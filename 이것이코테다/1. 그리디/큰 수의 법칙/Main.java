import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(" ");
        
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int k = Integer.parseInt(temp[2]);

        String[] numTemp = scan.nextLine().split(" ");
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(numTemp[i]);
        }

        int sum = 0;

        Arrays.sort(num);

        int big = num[n - 1];
        int sBig = num[n - 2];

        sum = m * big - (m / (k + 1)) * (big - sBig);

        System.out.println(sum);

        scan.close();
    }
}
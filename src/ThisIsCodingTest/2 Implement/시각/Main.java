import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i <= N; i++) {
            count += countPerHour(i, "3");
        }

        System.out.println(count);

        sc.close();
    }

    public static int countPerHour(int i, String target) {
        int countTemp = 0;

        int hourTemp = i;
        int minuteTemp = 0;
        int secondTemp = -1;

        while (true) {
            secondTemp++;

            if (secondTemp == 60) {
                secondTemp = 0;
                minuteTemp++;
            }
            if (minuteTemp == 60) {
                break;
            }

            if (doesContains(hourTemp, target) || doesContains(minuteTemp, target) || doesContains(secondTemp, target))
                countTemp++;
        }

        System.out.println(i + ":" + countTemp);

        return countTemp;
    }

    public static boolean doesContains(int a, String target) {
        return Integer.toString(a).contains(target);
    }
}

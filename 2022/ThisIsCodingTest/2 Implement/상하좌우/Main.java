import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine(); // nextInt()에서 "Enter"입력이 버퍼에 남아있어서 nextLine()이 종료되기 때문에 임의로 하나 넣어줌
        String[] route = sc.nextLine().split(" ");

        int[] pos = { 1, 1 };
        int[] posTemp = new int[2];

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        String[] moveType = { "L", "R", "U", "D" };

        for (String direction : route) {
            for (int i = 0; i < 4; i++) {
                if (direction.equals(moveType[i])) {
                    posTemp[0] = dx[i] + pos[0];
                    posTemp[1] = dy[i] + pos[1];
                    break;
                }
            }

            if (posTemp[0] < 1 || posTemp[0] > N || posTemp[1] < 1 || posTemp[1] > N) {
                continue;
            }

            pos[0] = posTemp[0];
            pos[1] = posTemp[1];
        }

        sc.close();
        
        System.out.println(pos[0] + " " + pos[1]);
    }
}

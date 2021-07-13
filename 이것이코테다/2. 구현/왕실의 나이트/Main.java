import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pos = sc.next();

        sc.close();

        int count = 0;

        int y = (int)pos.charAt(0) - 96;
        int x = Integer.parseInt(pos.substring(1));

        // System.out.println("y" + y + "x" + x);

        int[] dy = { -2, -2, -1, -1, 1, 1, 2, 2 };
        int[] dx = { -1, 1, -2, 2, -2, 2, -1, 1 };

        for (int i = 0; i < dy.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nx < 1 || ny < 1 || nx > 8 || ny > 8)
                continue;
            count++;
        }

        System.out.println(count);
    }
}

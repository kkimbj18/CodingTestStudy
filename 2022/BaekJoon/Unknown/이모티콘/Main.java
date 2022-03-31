import java.util.*;

public class Main {
    static int S;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;

        S = sc.nextInt();
        sc.close();

        dp = new int[S + 1][S + 1];

        for (int i = 0; i <= S; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        Queue<DpNode> pq = new LinkedList<>();

        pq.add(new DpNode(0, 1, 0));

        while(!pq.isEmpty()) {
            DpNode temp = pq.poll();

            if (temp.now < 0 || temp.now > S)
                continue;

            if (dp[temp.capture][temp.now] <= temp.tick)
                continue;
            else {
                dp[temp.capture][temp.now] = temp.tick;
            }

            if (temp.now == S) {
                answer = temp.tick;

                break;
            }

            pq.add(new DpNode(temp.now, temp.now, temp.tick + 1));
            pq.add(new DpNode(temp.capture, temp.now + temp.capture, temp.tick + 1));
            pq.add(new DpNode(temp.capture, temp.now - 1, temp.tick + 1));
        }

        // printAll();

        System.out.println(answer);
    }

    public static void printAll() {
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class DpNode {
    int capture;
    int now;
    int tick;

    DpNode(int capture, int now, int tick) {
        this.capture = capture;
        this.now = now;
        this.tick = tick;
    }
}

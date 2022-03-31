import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        boolean[] v = new boolean[X+1];

        Queue<Integer> q = new LinkedList<>();

        int phase = 0;
        q.add(X);
        loop1:
        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int a = q.poll();
                // System.out.println(phase + " " + a);
                if (a == 1) break loop1;

                if (a % 3 == 0) {
                    int temp = a / 3;
                    if (!v[temp]) {
                        v[temp] = true;
                        q.offer(temp);
                    }
                }
                if (a % 2 == 0) {
                    int temp = a / 2;
                    if (!v[temp]) {
                        v[temp] = true;
                        q.offer(temp);
                    }
                }

                int temp = a - 1;
                if (!v[temp]) {
                    v[temp] = true;
                    q.offer(temp);
                }
            }

            phase++;
        }

        System.out.println(phase);
    }
}

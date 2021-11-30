import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        br.close();

        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();

        pq1.add(arr[0]);
        bw.write(arr[0] + "\n");

        for (int i = 1; i < N; i++) {
            if (pq1.size() > pq2.size()) {
                int target = pq1.peek();

                if (arr[i] > target) {
                    pq2.add(arr[i]);
                } else {
                    pq1.poll();
                    pq1.add(arr[i]);
                    pq2.add(target);
                }
            } else {
                int target = pq2.peek();

                if (arr[i] > target) {
                    pq2.poll();
                    pq2.add(arr[i]);
                    pq1.add(target);
                } else {
                    pq1.add(arr[i]);
                }
            }

            bw.write(pq1.peek()+"");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}

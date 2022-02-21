package BaekJoon.Unknown.컵라면;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        Task[] tasks = new Task[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(tasks);

        for (int i = 0; i < N; i++) {
            int deadline = tasks[i].deadline;
            int value = tasks[i].value;

            pq.offer(value);

            if (!pq.isEmpty() && pq.size() > deadline) pq.poll();
        }

        int sum = 0;

        while(!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}

class Task implements Comparable<Task> {
    int deadline;
    int value;

    Task(int d, int v) {
        deadline = d;
        value = v;
    }

    @Override
    public int compareTo(Task t) {
        return this.deadline - t.deadline;
    }
}

package Programmers.Heap.디스크_컨트롤러;

import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int now = 0;

        PriorityQueue<Integer[]> readyHeap = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] t1, Integer[] t2) {
                return t1[1] > t2[1] ? 1 : -1;
            }
        });

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? 1 : -1;
            }
        });

        int idx = 0;

        while(true) {
            System.out.println("A");
            if (readyHeap.isEmpty()) {
                if (idx < jobs.length && jobs[idx][0] > now) {
                    System.out.println("B " + idx + " " + jobs[idx][0] + " " + jobs[idx][1] + " " + now + " " + answer);
                    readyHeap.add(Arrays.stream(jobs[idx]).boxed().toArray(Integer[]::new));
                    now = jobs[idx][0];
                    idx++;
                }
            }

            while(idx < jobs.length && jobs[idx][0] <= now) {
                System.out.println("C " + idx + " " + jobs[idx][0] + " " + jobs[idx][1] + " " + now + " " + answer);
                readyHeap.add(Arrays.stream(jobs[idx]).boxed().toArray(Integer[]::new));
                idx++;
            }

            if (readyHeap.isEmpty()) break;

            Integer[] target = readyHeap.poll();
            now = Math.max(target[0], now);
            now += target[1];
            answer += now - target[0];
        }

        System.out.println(now + " " + answer);

        return answer / jobs.length;
    }
}

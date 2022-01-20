package Programmers.Heap.이중우선순위큐;

import java.util.*;

class Solution {

    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;

    public int[] solution(String[] operations) {
        int[] answer = { 0, 0 };

        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation: operations) {
            String[] elements = operation.split(" ");

            if (elements[0].equals("I")) {
                insert(Integer.parseInt(elements[1]));
            } else if (elements[0].equals("D")) {
                remove(Integer.parseInt(elements[1]));
            }
        }

        if (!minHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }

    public void insert(int e) {
        minHeap.add(e);
        maxHeap.add(e);
    }

    public void remove(int opt) {
        if (minHeap.isEmpty()) return;

        if (opt == 1) {
            int max = maxHeap.poll();
            minHeap.remove(max);
        } else if (opt == -1) {
            int min = minHeap.poll();
            maxHeap.remove(min);
        }
    }
}

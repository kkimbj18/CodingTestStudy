package Programmers.Heap.더_맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int s: scoville) {
            minHeap.add(s);
        }
        
        if (minHeap.peek() >= K) return answer;
        
        while(true) {
            answer++;
            int[] minFoods = new int[2];
            
            minFoods[0] = minHeap.poll();
            minFoods[1] = minHeap.poll();
            
            int newFood = minFoods[0] + (minFoods[1] * 2);
            minHeap.add(newFood);
            if (minHeap.peek() > K) break;
            
            if (minHeap.size() == 1) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}
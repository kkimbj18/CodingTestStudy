import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<Integer> q = new LinkedList<>();
        int[] priorityCount = new int[10];
        
        for (int p : priorities) {
            q.add(p);
            priorityCount[p]++;
        }
        
        while(true) {
            boolean check = false;
            int temp = q.poll();
            
            for (int i = temp + 1; i < 10; i++) {
                if (priorityCount[i] > 0) {
                    check = true;
                    break;
                }
            }
            
            if (!check) {
                if (location == 0) break;
                answer++;
                priorityCount[temp]--;
            } else {
                q.add(temp);
            }
            
            if (location == 0) {
                location = q.size() - 1;
            } else {
                location--;
            }
        }
        
        return answer;
    }
}
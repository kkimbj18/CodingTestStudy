import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> a = new ArrayList<>();
        int len = progresses.length;
        
        Queue<Task> q = new LinkedList<>();
        
        for (int i = 0; i < len; i++) {
            Task temp = new Task(progresses[i], speeds[i]);
            q.add(temp);
        }
        
        while(!q.isEmpty()) {
            int count = 1;
            
            Task currTask = q.poll();
            
            int rest = 100 - currTask.progress;
            int countTemp = (int)Math.ceil((double)rest / currTask.speed);
            
            while(!q.isEmpty()) {
                Task nextTask = q.peek();
                
                int r = 100 - nextTask.progress;
                int cTemp = (int)Math.ceil((double)r / nextTask.speed);
                
                if (countTemp < cTemp) break;
                
                q.poll();
                count++;
            }
            
            a.add(count);
        }
        
        return a;
    }
}

class Task {
    int progress;
    int speed;
    
    Task(int p, int s) {
        this.progress = p;
        this.speed = s;
    }
}
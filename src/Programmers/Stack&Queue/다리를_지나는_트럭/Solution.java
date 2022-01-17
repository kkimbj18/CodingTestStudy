import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;
        
        Queue<Integer> pq = new LinkedList<>();
        Queue<Truck> rq = new LinkedList<>();
        
        for (int tw: truck_weights) {
            pq.add(tw);
        }
        
        while (!pq.isEmpty()) {
            answer++;
            
            if (!rq.isEmpty()) {
                if (rq.peek().location == bridge_length) {
                    Truck t = rq.poll();
                    bridge_weight -= t.weight;
                }
                for (Truck t: rq) {
                    t.location++;
                }
            }
            
            if (bridge_weight + pq.peek() > weight) {
                continue;
            }
            
            Truck t = new Truck(1, pq.poll());
            bridge_weight += t.weight;
            rq.add(t);
        }
        
        answer += bridge_length;
        
        return answer;
    }
}

class Truck {
    int location;
    int weight;
    
    Truck(int l, int w) {
        location = l;
        weight = w;
    }
}
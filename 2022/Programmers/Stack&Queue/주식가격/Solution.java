import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Price> s = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!s.isEmpty() && s.peek().val > prices[i]) {
                for (Price p: s) {
                    answer[p.idx]++;
                }
                s.pop();
            }
            
            Price p = new Price(prices[i], i);
            s.push(p);
        }
        
        while(!s.isEmpty()) {
            s.pop();
            
            for (Price p: s) {
                answer[p.idx]++;
            }
        }
        
        return answer;
    }
}

class Price {
    int val;
    int idx;
    
    Price(int v, int i) {
        val = v;
        idx = i;
    }
}
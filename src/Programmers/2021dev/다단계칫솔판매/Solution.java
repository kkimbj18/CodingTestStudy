import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int N = enroll.length;
        int M = seller.length;
        
        Map<String, Node> map = new HashMap<>();
        int[] answer = new int[N];
        
        for (int i = 0; i < N; i++) {
            Node newNode = new Node(0);
            map.put(enroll[i], newNode);
            
            if (referral[i].equals("-")) continue;
            
            newNode.parent = map.get(referral[i]);
        }
        
        for (int i = 0; i < M; i++) {
            Node n = map.get(seller[i]);
            int rest = amount[i] * 100;
            
            while(n != null) {
                int mine = rest - rest / 10;
                rest -= mine;
                
                n.amount += mine;
                n = n.parent;
            }
        }
        
        for (int i = 0; i < N; i++) {
            answer[i] = map.get(enroll[i]).amount;
        }
        
        return answer;
    }
}

class Node {
    int amount;
    Node parent;
    
    Node(int amount) {
        this.amount = amount;
    }
}
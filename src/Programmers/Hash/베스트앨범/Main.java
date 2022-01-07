import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int len = genres.length;
        
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, PriorityQueue<Music>> map = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            Integer val = countMap.get(genres[i]);
            PriorityQueue<Music> q;
            
            if (val == null) {
                countMap.put(genres[i], plays[i]);
                q = new PriorityQueue<>((a, b) -> 
                    b.plays - a.plays
                );
            } else {
                countMap.put(genres[i], val + plays[i]);
                q = map.get(genres[i]);
            }
            Music m = new Music(i, plays[i]);
                
            q.add(m);
            map.put(genres[i], q);
        }
        
        ArrayList<String> keyList = new ArrayList<>(countMap.keySet());
        
        Collections.sort(keyList, (a, b) -> countMap.get(b).compareTo(countMap.get(a)));
        
        for (String key: keyList) {
            for (int i = 0; i < 2; i++) {
                Music m = map.get(key).poll();
                
                if (m == null) break;
                answer.add(m.index);
            }
        }
        
        return answer;
    }
}

class Music {
    int index;
    int plays;
    
    Music(int i, int p) {
        index = i;
        plays = p;
    }
}
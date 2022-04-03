package Programmers.Sort.H_Index;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Integer[] citationList = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(citationList, Collections.reverseOrder());
        
        loop1:
        for (int h = citations.length; h >= 1; h--) {
            for (int j = h - 1; j >= 0; j--) {
                if (citationList[j] < h) continue loop1; 
            }

            answer = h;
            break;
        }

        // System.out.println(Arrays.toString(citations));

        return answer;
    }
}
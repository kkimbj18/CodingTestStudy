package Programmers.ExhaustiveSearch.모의고사;

import java.util.ArrayList;

class Solution {
    static int[][] S = {
        { 1, 2, 3, 4, 5 },
        { 2, 1, 2, 3, 2, 4, 2, 5 },
        { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
    };

    public int[] solution(int[] answers) {
        int max = -1;
        int[] count = new int[3];

        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (S[j][i % S[j].length] == answers[i]) count[j]++;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (count[i] > max) {
                max = count[i];
                list.clear();
                list.add(i+1);
            } else if (count[i] == max) {
                list.add(i+1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
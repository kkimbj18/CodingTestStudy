package Programmers.Sort.K번째수;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt = 0;

        for (int[] command: commands) {
            int[] copiedArr = new int[command[1]-command[0] + 1];
            int count = 0;

            for (int i = command[0] - 1; i < command[1]; i++) {
                copiedArr[count++] = array[i];
            }

            Arrays.sort(copiedArr);

            answer[cnt++] = copiedArr[command[2]-1];
        }

        return answer;
    }
}
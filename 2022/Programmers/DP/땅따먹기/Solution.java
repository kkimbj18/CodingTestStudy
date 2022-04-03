package Programmers.DP.땅따먹기;

import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        
        int[][] dp = new int[N][4];
        
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                for (int z = 0; z < 4; z++) {
                    if (j == z) continue;
                    
                    dp[i][j] = Math.max(dp[i-1][z] + land[i][j], dp[i][j]);
                }
            }
        }
        
        Arrays.sort(dp[N-1]);
        
        answer = dp[N-1][3];

        return answer;
    }
}
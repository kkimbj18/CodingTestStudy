package Programmers.Greedy.체육복;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        int[] arr = new int[n+2];

        for (int l: lost) {
            arr[l]--;
        }
        for (int r: reserve) {
            arr[r]++;
        }

        for (int l = 1; l <= n; l++) {
            if (arr[l] != -1) continue;

            if (arr[l-1] == 1) {
                arr[l-1]--;
            } else if (arr[l+1] == 1) {
                arr[l+1]--;
            } else {
                answer--;
                continue;
            }

            arr[l]++;
        }

        return answer;
    }
}
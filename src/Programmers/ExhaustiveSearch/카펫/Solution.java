package Programmers.ExhaustiveSearch.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int sum = (brown + 4) / 2;

        for (int x = 3; x <= sum - 3; x++) {
            if ((x-2) * (sum-x-2) == yellow) {
                int max = Math.max(x, sum-x);
                answer = new int[] { max, sum-max };
                break;
            }
        }

        return answer;
    }
}

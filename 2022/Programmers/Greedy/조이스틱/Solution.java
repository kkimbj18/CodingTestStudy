package Programmers.Greedy.조이스틱;

class Solution {

    public int solution(String name) {

        int answer = 0;

        int N = name.length();
        char[] subName = name.toCharArray();

        for (char s: subName) {
            answer += Math.min(s - 'A', 'A' + 26 - s);
        }

        int min = N - 1;

        for (int i = 0; i < N; i++) {
            int next = i + 1;

            while (next < N && subName[next] == 'A') {
                next++;
            }

            min = Math.min(min, i + N - next + Math.min(i, N - next));
        }

        answer += min;

        return answer;
    }
}

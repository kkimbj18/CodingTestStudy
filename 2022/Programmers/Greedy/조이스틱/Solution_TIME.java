package Programmers.Greedy.조이스틱;

class Solution_TIME {

    public static int answer = Integer.MAX_VALUE;
    public static int N;

    public int solution(String name) {

        N = name.length();

        String currName = "";
        for (int i = 0; i < N; i++) {
            currName += "A";
        }

        dfs(name, currName, 0, 0);

        return answer;
    }

    public void dfs(String name, String currName, int cursor, int count) {
        if (count >= answer) return;
        
        char curr = currName.charAt(cursor);
        char target = name.charAt(cursor);

        if (curr != target) {
            int temp = Math.min(target - curr, curr + 26 - target);
            count += temp;
            currName = currName.substring(0, cursor) + target + currName.substring(cursor+1);
        }

        if (name.equals(currName)) {
            if (count < answer)
                answer = count;

            return;
        }

        dfs(name, currName, (cursor+1) % N, count+1);
        dfs(name, currName, (cursor-1 < 0) ? N-1 : cursor-1, count+1);
    }
}

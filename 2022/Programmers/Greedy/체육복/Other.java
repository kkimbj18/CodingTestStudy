package Programmers.Greedy.체육복;

import java.util.Arrays;

class Other {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        int start = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        Integer[] losts = Arrays.stream(lost).boxed().toArray(Integer[]::new);

        boolean[] stolen = new boolean[reserve.length];
        boolean[] hasMore = new boolean[lost.length];

        for (int i = 0; i < reserve.length; i++) {
            int idx = Arrays.asList(losts).indexOf(reserve[i]);
            // System.out.println("F: " + i + " " + idx);

            if (idx > -1) {
                stolen[i] = true;
                hasMore[idx] = true;
                answer++;
            }
        }

        for (int j = 0; j < lost.length; j++) {
            if (hasMore[j]) continue;

            int l = lost[j];

            for (int i = start; i < reserve.length; i++) {
                if (stolen[i]) continue;

                if (Math.abs(l - reserve[i]) <= 1) {
                    // System.out.println("T: " + l + " " + reserve[i]);
                    start = i + 1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
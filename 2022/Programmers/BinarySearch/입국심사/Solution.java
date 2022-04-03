import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        ArrayList<Long> candidates = new ArrayList<>();

        Arrays.sort(times);

        long unit_time = (long)(n / times.length + 1);
        long left = unit_time;
        long right = unit_time * times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int t : times) {
                sum += (long) (mid / t);
            }

            if (sum < n)
                left = mid + 1;
            else {
                right = mid - 1;
                candidates.add(mid);
            }
        }

        answer = Collections.min(candidates);

        // candidates.forEach(System.out::println);

        return answer;
    }
}

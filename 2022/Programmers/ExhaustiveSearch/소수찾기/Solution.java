package Programmers.ExhaustiveSearch.소수찾기;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static Set<Integer> set;

    public int solution(String numbers) {
        int answer = 0;

        char[] nums = numbers.toCharArray();

        permutationAll(nums);

        // System.out.println(set);

        loop1:
        for (Integer s: set) {
            if (s < 2) continue loop1;

            // System.out.println(s + ": " + Math.sqrt(s));
            for (int i = 2; i <= (int)Math.sqrt(s); i++) {
                if (s % i == 0) {
                    continue loop1;
                }
            }

            // System.out.println(s);
            answer++;
        }
        

        return answer;
    }

    public void permutationAll(char[] nums) {
        set = new HashSet<>();

        for (int i = 1; i <= nums.length; i++) {
            // System.out.println(i);
            permutation(nums, i, new boolean[nums.length], "");
        }
    }

    public void permutation(char[] nums, int r, boolean[] visited, String tempNum) {
        if (r == 0) {
            set.add(Integer.parseInt(tempNum));
            // System.out.println("반환: " + tempNum);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempNum += nums[i];
                permutation(nums, r-1, visited, tempNum);
                tempNum = tempNum.substring(0, tempNum.length() - 1);
                visited[i] = false;
            }
        }
    }
}
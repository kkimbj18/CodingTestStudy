package Programmers.Sort.가장_큰_수;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = (Integer)numbers[i];
        }

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {

                String str1 = i1+""+i2;
                String str2 = i2+""+i1;

                return str2.compareTo(str1);
            }
        });

        for (int number: nums) {
            answer += number;
        }

        answer = (answer.charAt(0) == '0') ? "0" : answer;

        return answer;
    }
}
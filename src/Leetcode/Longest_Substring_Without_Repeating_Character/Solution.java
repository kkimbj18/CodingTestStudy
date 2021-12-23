class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;

        int left = 0;
        int right = -1;

        int[] currCount = new int[128];

        while (right < s.length() - 1) {
            right++;

            char now = s.charAt(right);

            int nowInt = now - 0;

            while (currCount[nowInt] >= 1) {
                char temp = s.charAt(left);
                left++;
                count--;
                currCount[temp - 0]--;
            }
            currCount[nowInt]++;

            count++;
            if (count > max)
                max = count;
        }

        return max;
    }
}
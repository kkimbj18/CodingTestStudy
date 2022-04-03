class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double answer;

        int left = 0;
        int right = 0;
        int sum = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] concate = new int[len1 + len2];

        while (left < len1 && right < len2) {
            if (nums1[left] > nums2[right]) {
                concate[sum++] = nums2[right++];
            } else {
                concate[sum++] = nums1[left++];
            }
        }

        if (left == len1) {
            System.arraycopy(nums2, right, concate, sum, len2 - right);
        } else {
            System.arraycopy(nums1, left, concate, sum, len1 - left);
        }

        int len = concate.length;
        int midLen = len / 2;

        if (len % 2 == 0) {
            answer = (double)(concate[midLen - 1] + concate[midLen]) / 2;
        } else {
            answer = concate[midLen];
        }

        return answer;
    }
}

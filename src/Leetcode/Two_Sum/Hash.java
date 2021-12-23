import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < len; i++) {

            Integer diff = (Integer) (target - nums[i]);

            if (hash.containsKey(diff)) {
                return new int[] { hash.get(diff), i };
            }

            hash.put(nums[i], i);
        }

        return null;
    }
}

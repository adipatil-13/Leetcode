class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min_res = Integer.MAX_VALUE;
        int left = 0, curr = 0; 

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr >= target) {
                min_res = Math.min(min_res, right - left + 1);
                curr -= nums[left++];
            }
        }
        return min_res == Integer.MAX_VALUE ? 0 : min_res;
    }
}

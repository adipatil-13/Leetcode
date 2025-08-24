class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, res = 0;
        int zero = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zero++;

            while (zero > 1) {
                if (nums[left] == 0) zero--;
                left++; 
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
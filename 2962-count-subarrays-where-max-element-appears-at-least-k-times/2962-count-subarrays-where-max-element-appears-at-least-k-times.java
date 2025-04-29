class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(max, num);
        long res = 0, maxOccurence = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                maxOccurence++;
            }
            while (maxOccurence >= k) {
                if (nums[left] == max) {
                    maxOccurence--;
                }
                left++;
            }
            res += left;
        }
        return res;
    }
}
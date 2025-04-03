class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0, maxDiff = 0, maxElement = 0;

        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, maxDiff * nums[i]);
            maxElement = Math.max(maxElement, nums[i]);
            maxDiff = Math.max(maxDiff, maxElement - nums[i]);
        }
        return res;
    }
}
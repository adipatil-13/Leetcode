class Solution {
    public int maximumDifference(int[] nums) {
        int diff = -1;
        int ele = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ele) {
                diff = Math.max(diff, nums[i] - ele);
            }
            if (nums[i] < ele) {
                ele = nums[i];
            }
        }
        return diff;
    }
}
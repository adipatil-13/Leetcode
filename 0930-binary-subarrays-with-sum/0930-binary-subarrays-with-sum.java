class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }
    private int helper(int[] nums, int goal){
        if (goal < 0) return 0;
        
        int left = 0, count = 0, sum = 0;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
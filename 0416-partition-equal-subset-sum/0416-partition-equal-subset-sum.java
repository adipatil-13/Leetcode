class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) 
            total += num;
        
        if (total % 2 == 1) return false;

        int target = total / 2;

        int [][] dp = new int[n][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return subsetSum(n - 1, target, nums, dp);
    }
    private boolean subsetSum(int idx, int target, int[] nums, int[][] dp) {
        if (target == 0) return true;
        if (idx == 0) return nums[0] == target;

        if (dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean notTaken = subsetSum(idx - 1, target, nums, dp);

        boolean taken = false;
        if (nums[idx] <= target) {
            taken = subsetSum(idx - 1, target - nums[idx], nums, dp);
        }

        dp[idx][target] = (notTaken || taken) ? 1 : 0;
        return notTaken || taken;
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;
        int targetSum = total / 2;

        boolean[][] dp = new boolean[n][targetSum + 1];

        // Base case: sum 0 is always possible
        for (int i = 0; i < n; i++) dp[i][0] = true;

        // Initialize first row
        if (nums[0] <= targetSum) dp[0][nums[0]] = true;

        // Fill DP table
        for (int idx = 1; idx < n; idx++) {
            for (int target = 1; target <= targetSum; target++) {
                boolean notTaken = dp[idx - 1][target];
                boolean taken = false;
                if (nums[idx] <= target) {
                    taken = dp[idx - 1][target - nums[idx]];
                }
                dp[idx][target] = notTaken || taken;
            }
        }
        return dp[n - 1][targetSum];
    }
}
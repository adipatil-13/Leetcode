class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // If the sum is odd, partition into equal subsets is impossible
        if (totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;

        // prev[sum] indicates if a subset with 'sum' is possible so far
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;

        // Initialize with first element
        if (nums[0] <= target)
            prev[nums[0]] = true;

        // Iterate over all remaining elements
        for (int i = 1; i < n; i++) {
            // cur[sum] will store possibilities for current element
            boolean[] cur = new boolean[target + 1];
            cur[0] = true;

            for (int sum = 1; sum <= target; sum++) {
                boolean notTaken = prev[sum];

                boolean taken = false;
                if (nums[i] <= sum)
                    taken = prev[sum - nums[i]];

                // Current sum possible if either option is true
                cur[sum] = notTaken || taken;
            }
            // Move to next element
            prev = cur;
        }
        return prev[target];
    }
}
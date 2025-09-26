class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;

        int prev = 0, prev1 = 0;
        for (int i = 0; i < n - 1; i++) {
            int temp = prev;
            prev = Math.max(prev, prev1 + nums[i]);
            prev1 = temp;
        }
        int ans1 = prev;

        prev = 0; prev1 = 0;
        for (int i = 1; i < n; i++) {
            int temp = prev;
            prev = Math.max(prev, prev1 + nums[i]);
            prev1 = temp;
        }
        return Math.max(prev, ans1);
    }
}
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int prev = 0, prev1 = 0;

        for (int num : nums) {
            int temp = prev;
            prev = Math.max(prev, num + prev1);
            prev1 = temp;
        }
        return prev;
    }
}
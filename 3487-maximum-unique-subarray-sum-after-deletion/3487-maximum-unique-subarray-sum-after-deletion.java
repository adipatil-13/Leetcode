class Solution {
    public int maxSum(int[] nums) {
        int res = 0, min = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                if (nums[i] >= 0) res += nums[i];
                else min = Math.max(min, nums[i]);
            }
            set.add(nums[i]);
        }
        if (res == 0 && !set.contains(0)) return min;
        return res;
    }
}
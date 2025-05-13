class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0, leftSum = 0, rightSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum = totalSum - nums[i] - leftSum;
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
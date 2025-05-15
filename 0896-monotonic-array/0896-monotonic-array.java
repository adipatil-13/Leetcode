class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) isIncreasing = true;
            else if (nums[i] < nums[i - 1]) isDecreasing = true;
            if (isIncreasing && isDecreasing) return false;
        }
        return true;
    }
}

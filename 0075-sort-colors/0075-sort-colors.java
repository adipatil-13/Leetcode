class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, i = 0;

        while (i <= high) {
            if (nums[i] == 0) {
                swap(nums, low, i);
                low++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
    }
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
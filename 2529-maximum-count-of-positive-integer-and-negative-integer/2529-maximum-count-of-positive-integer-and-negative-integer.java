class Solution {
    public int maximumCount(int[] nums) {
        int negatives = binarysearch(nums, 0);
        int positives = nums.length - binarysearch(nums, 1);
        return Math.max(positives, negatives);
    }
    private int binarysearch(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int res = nums.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[left] <= nums[right]) {
                res = Math.min(res, nums[left]);
                break;
            }
            if(nums[left] <= nums[mid]) {
                res = Math.min(res, nums[left]);
                left = mid + 1;
            } else {
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            }
        }
        return res;
    }
}
/*
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
*/
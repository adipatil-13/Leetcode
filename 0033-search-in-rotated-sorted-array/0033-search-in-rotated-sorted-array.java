class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }
            if (nums[left] <= nums[mid]){
                if (nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
/*
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        // Step 1: Find the pivot using binary search
        while (l < r) {
            int m = (l + r) / 2;  // Middle index
            if (nums[m] > nums[r]) {
                // The right side is unsorted, so the pivot is on the right side of m
                l = m + 1;
            } else {
                // The pivot is on the left side of m or at m itself
                r = m;
            }
        }

        int pivot = l;  // The pivot index is where the array was rotated

        // Step 2: Perform binary search in the first half
        int result = binarySearch(nums, target, 0, pivot - 1);
        if (result != -1) {
            return result;
        }

        // Step 3: Perform binary search in the second half
        return binarySearch(nums, target, pivot, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;  // Target found
            } else if (nums[mid] < target) {
                left = mid + 1;  // Target is on the right side
            } else {
                right = mid - 1;  // Target is on the left side
            }
        }
        return -1;  // Target not found
    }
}
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first = -1, last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                first = mid;
                last = mid;

                while (first - 1 >= 0 && nums[first - 1] == target) {
                    first--;
                }
                while (last + 1 < nums.length && nums[last + 1] == target) {
                    last++;
                }

                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] {first, last};
    }
}
/*
public int[] searchRange(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    int first = -1, last = -1;
    // First
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            first = mid;
            high = mid - 1;
        } else if (nums[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    low = 0;
    high = nums.length - 1;
    // last
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            last = mid;
            low = mid + 1;
        } else if (nums[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return new int[] {first, last};
}
*/
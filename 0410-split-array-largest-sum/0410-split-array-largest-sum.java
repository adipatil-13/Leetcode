class Solution {
    public int splitArray(int[] nums, int k) {
        if (k > nums.length) return -1;
        int max = -1, total = 0;

        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
            max = Math.max(max, nums[i]);
        }
        int left = max, right = total;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, mid, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isValid(int[] nums, int target, int k) {
        int cnt = 1, total = 0;

        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                cnt++;
                if (cnt > k) return false;
            }
        }
        return true;
    }
}
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007 , n = nums.length;

        int[] power = new int[n];
        power[0] = 1;

        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int left = 0, right = n - 1, res = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res += power[right - left] % mod;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
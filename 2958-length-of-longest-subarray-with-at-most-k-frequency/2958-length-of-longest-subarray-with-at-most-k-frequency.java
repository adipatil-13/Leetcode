class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right] , 0) + 1);

            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
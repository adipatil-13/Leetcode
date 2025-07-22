class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[10001];
        int left = 0;
        int currSum = 0;
        int res = 0;
        
        for (int right = 0; right < n; right++) {
            while (seen[nums[right]]) {
                currSum -= nums[left];
                seen[nums[left]] = false;
                left++;
            }

            currSum += nums[right];
            seen[nums[right]] = true;

            if (currSum > res) {
                res = currSum;
            }
        }
        return res;
    }
}
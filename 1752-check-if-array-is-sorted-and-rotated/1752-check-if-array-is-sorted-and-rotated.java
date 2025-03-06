class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        
        for (int i = 1; i < n && cnt <= 1; i++) {
            if (nums[i] < nums[i - 1]) cnt++;
        }
        return (nums[0] >= nums[n - 1] && cnt == 1) || cnt == 0;
    }
}
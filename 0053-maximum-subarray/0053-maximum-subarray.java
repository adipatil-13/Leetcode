class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane Algorithm, O(n), O(1)
        int res = Integer.MIN_VALUE, sum = 0;

        for(int i = 0; i < nums.length; i++){
            if(sum < 0) sum = 0;
            sum += nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
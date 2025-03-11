class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0, right = 0, res = 0, zeroCount = 0;

        for(right = 0; right < nums.length; right++){
            
            if(nums[right] == 0){
                zeroCount++;
            }
            while (zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}

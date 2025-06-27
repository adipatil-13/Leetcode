class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }

        int l = 1;
        for(int i = 0; i< nums.length; i++){
            res[i] *= l;
            l *= nums[i];
        }

        int r = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }
}
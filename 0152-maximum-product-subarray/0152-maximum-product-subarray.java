class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int l = 1, r = 1;
        int res = nums[0];
        
        for(int i = 0; i < n; i++){
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;
            
            l *= nums[i]; 
            r *= nums[n - 1 - i];
            
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int prefix = 0;
        int[] count = new int[k];
        count[0] = 1;

        for (int num : nums) {
           prefix = (prefix + num % k + k) % k;
           res += count[prefix];
           ++count[prefix];
        }

        return res;
    }
}
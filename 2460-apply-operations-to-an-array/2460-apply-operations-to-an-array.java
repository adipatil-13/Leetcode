class Solution {
    public int[] applyOperations(int[] nums) {
        int k = 0, i;
        int[] res = new int[nums.length];

        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    res[k] = nums[i] * 2;
                    i++;
                } else {
                    res[k] = nums[i];
                }
                k++;
            }
        }
        if (i != nums.length) {
            res[k] = nums[nums.length - 1];
        }
        return res;
    }
}
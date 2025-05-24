class Solution {
    public int jump(int[] nums) {
        int near = 0, far = 0, res = 0;

        while (far < nums.length - 1) {
            int farMax = 0;
            for (int i = near; i <= far; i++) {
                farMax = Math.max(farMax, i + nums[i]);
            }
            near = far + 1;
            far = farMax;
            res++;
        }

        return res;
    }
}
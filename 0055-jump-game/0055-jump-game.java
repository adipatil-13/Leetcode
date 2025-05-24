class Solution {
    public boolean canJump(int[] nums) {
        // int goal = nums.length - 1;

        // for (int i = nums.length - 2; i >= 0; i--) {
        //     if (i + nums[i] >= goal) {
        //         goal = i;
        //     }
        // }

        // return goal == 0;

        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return true;
    }
}
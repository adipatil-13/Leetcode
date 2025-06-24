class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; ) {
            int num = nums[i];
            if (num == i + 1) {
                i++;
            } else if (num == nums[num - 1]) {
                return num;
            } else {
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
            }
        }
        return 0;
    }
}
class Solution {
    public int findNumbers(int[] nums) {
        String[] stNums = new String[nums.length];

        for (int i = 0; i < stNums.length; i++) {
            stNums[i] = String.valueOf(nums[i]);
        }
        int count = 0;

        for (int i = 0; i < stNums.length; i++) {
            if (stNums[i].length() % 2 == 0) {
                count++;
            } 
        }
        return count;
    }
}
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int[][] res = new int[nums.length / 3][3];

        for (int i = 0; i < nums.length; i += 3) {
            int a = nums[i], b = nums[i + 1], c = nums[i + 2];
            if (c - a > k) return new int[0][];
            res[i / 3][0] = a;
            res[i / 3][1] = b;
            res[i / 3][2] = c;
        }
        return res;
    }
}
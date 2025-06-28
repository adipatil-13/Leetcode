class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] pairs = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new int[]{nums[i], i};
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        Arrays.sort(pairs, 0, k, (a, b) -> a[1] - b[1]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pairs[i][0];
        }

        return res;
    }
}
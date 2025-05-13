class NumArray {

    private int[] prefixSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n + 1];

        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        // prefixSum[right+1] gives sum of all elements upto right, prefixSum[left] gives sum of all elements upto left-1.
        return prefixSum[right + 1] - prefixSum[left];
    }
}
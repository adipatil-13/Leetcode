class Solution {
    public int maximumGap(int[] nums) {
        int res = 0;
        int n  = nums.length;
        if (n < 2) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int bucketSize = (int)Math.ceil((double)(max - min) / (n - 1));

        int[] minOfBucket = new int[n - 1];
        int[] maxOfBucket = new int[n - 1];

        Arrays.fill(minOfBucket, Integer.MAX_VALUE);
        Arrays.fill(maxOfBucket, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            if (nums[i] == min || nums[i] == max) continue;

            int bucketIdxForCurrEle = (nums[i] - min) / bucketSize;

            minOfBucket[bucketIdxForCurrEle] = Math.min(minOfBucket[bucketIdxForCurrEle], nums[i]);
            maxOfBucket[bucketIdxForCurrEle] = Math.max(maxOfBucket[bucketIdxForCurrEle], nums[i]);
        }
        // Calculate gap using MinB - MaxA

        for (int i = 0; i < n - 1; i++) {
            if (maxOfBucket[i] == Integer.MIN_VALUE) continue;

            res = Math.max(minOfBucket[i] - min, res);
            min = maxOfBucket[i];
        }

        res = Math.max(res, max - min);
        return res;
    }
}